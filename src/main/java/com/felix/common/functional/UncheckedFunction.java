package com.felix.common.functional;

import java.util.function.Function;

/**
 * Functional interface to resolve checked exceptions to unchecked.
 */
@FunctionalInterface
public interface UncheckedFunction<T, R, E extends Throwable> {

    R apply(T t) throws E;

    static <T, R, E extends Throwable> Function<T, R> unchecked(UncheckedFunction<T, R, E> f) {
        return t -> {
            try {
                return f.apply(t);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }
}
