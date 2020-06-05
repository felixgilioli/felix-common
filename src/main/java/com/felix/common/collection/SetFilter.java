package com.felix.common.collection;

import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

public class SetFilter<T, S> {

        private final Set<T> set;
        private Function<T, S> compareFunction;

        private SetFilter(Set<T> set) {
            this.set = set;
        }

        private SetFilter(Set<T> set, Function<T, S> compareFunction) {
            this.set = set;
            this.compareFunction = compareFunction;
        }

    public static <T> SetFilter<T, ?> of(Set<T> set) {
        return new SetFilter<>(set);
    }

    public <U> SetFilter<T, U> compareWith(Function<T, U> compareFunction) {
        return new SetFilter<>(this.set, compareFunction);
    }

    public Optional<T> next(S obj) {
        return set.stream()
                .filter(l -> compareFunction.apply(l).equals(obj))
                .findFirst();
    }
}
