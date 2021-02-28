package com.felix.common.collection;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Class that contains methods to make it easier to filter objects in a {@link List}.
 */
public class ListFilter<T, S> {

    private final List<T> list;
    private Function<T, S> compareFunction;

    private ListFilter(List<T> list) {
        this.list = list;
    }

    private ListFilter(List<T> list, Function<T, S> compareFunction) {
        this.list = list;
        this.compareFunction = compareFunction;
    }

    /**
     * Receive a list of elements to filtrate.
     * @param list list of elements to filtrate.
     * @param <T> generic type of list.
     * @return instance of {@link ListFilter}.
     */
    public static <T> ListFilter<T, ?> of(List<T> list) {
        return new ListFilter<>(list);
    }

    /**
     * Informs the function to compare elements in list.
     * @param compareFunction comparison function.
     * @param <U> generic type of element to filter.
     * @return this.
     */
    public <U> ListFilter<T, U> compareWith(Function<T, U> compareFunction) {
        return new ListFilter<>(this.list, compareFunction);
    }

    /**
     * Returns element filtering by comparator.
     * @param obj filter object.
     * @return object in list if exists.
     */
    public Optional<T> next(S obj) {
        return list.stream()
                .filter(l -> compareFunction.apply(l).equals(obj))
                .findFirst();
    }
}
