package com.felix.common.collection;

import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

/**
 * Class that contains methods to make it easier to filter objects in a {@link Set}.
 */
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

    /**
     * Receive a set of elements to filtrate.
     * @param set set of elements to filtrate.
     * @param <T> generic type of set.
     * @return instance of {@link SetFilter}.
     */
    public static <T> SetFilter<T, ?> of(Set<T> set) {
        return new SetFilter<>(set);
    }

    /**
     * Informs the function to compare elements in set.
     * @param compareFunction comparison function.
     * @param <U> generic type of element to filter.
     * @return this.
     */
    public <U> SetFilter<T, U> compareWith(Function<T, U> compareFunction) {
        return new SetFilter<>(this.set, compareFunction);
    }

    /**
     * Returns element filtering by comparator.
     * @param obj filter object.
     * @return object in set if exists.
     */
    public Optional<T> next(S obj) {
        return set.stream()
                .filter(l -> compareFunction.apply(l).equals(obj))
                .findFirst();
    }
}
