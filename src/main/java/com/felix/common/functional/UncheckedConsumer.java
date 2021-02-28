package com.felix.common.functional;

import java.util.function.Consumer;

/**
 * Functional interface to resolve checked exceptions to unchecked.
 */
@FunctionalInterface
public interface UncheckedConsumer<T, E extends Throwable> {

    void accept(T t) throws E;

    /**
     * Method to returns a instance of {@link UncheckedConsumer}.
     * @param consumer consumer.
     * @return instance of {@link UncheckedConsumer}.
     */
    static <T, E extends Throwable> Consumer<T> unchecked(UncheckedConsumer<T, E> consumer) {
        return (t) -> {
            try {
                consumer.accept(t);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }
}
