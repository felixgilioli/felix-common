package com.felix.common.collection;

import java.util.Collections;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * Class that contains methods for working with {@link List}.
 */
public class Lists {

    /**
     * Convert a collection of a type to a list of another type.
     * @param c collection.
     * @param function function to map.
     * @param <T> generic type of list.
     * @param <S> generic type of collection.
     * @return a converted list.
     */
    public static <T, S> List<T> map(Collection<S> c, Function<S, T> function) {
        requireNonNull(c);
        requireNonNull(function);

        return c.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    /**
     * Returns a null list if is empty.
     * @param c list.
     * @param <T> generic type of list.
     * @return a null list if is empty, return herself if not empty.
     */
    public static <T> List<T> nullIfEmpty(List<T> c) {
        if (c == null)
            return null;

        return c.isEmpty() ? null : c;
    }

    /**
     * Returns a empty list if is null.
     * @param c list.
     * @param <T> generic type of list.
     * @return a empty list if is null, return herself if not null.
     */
    public static <T> List<T> emptyIfNull(List<T> c) {
        return c == null ? Collections.emptyList() : c;
    }

    /**
     * Returns a grouped list.
     * @param list list.
     * @param function returns property to grouping.
     * @param <K> generic type of key.
     * @param <V> generic type of value.
     * @return Grouped Map.
     */
    public static <K, V> Map<K, List<V>> groupBy(List<V> list, Function<V, K> function) {
        requireNonNull(list);
        requireNonNull(function);
        return list.stream()
                .collect(Collectors.groupingBy(function));
    }

    /**
     * Filter elements in a list.
     * @param list list to filter.
     * @param predicate condition to filter.
     * @param <T> generic type of list.
     * @return a filtered list.
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        requireNonNull(list);
        requireNonNull(predicate);
        return list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    /**
     * Sort elements in a list.
     * @param list list to sort.
     * @param function function to sort list.
     * @param <T> generic type of list.
     * @param <U> generic type of property to filter.
     * @return a sorted list.
     */
    public static <T, U extends Comparable<? super U>> List<T> sort(List<T> list, Function<T, U> function) {
        requireNonNull(list);
        requireNonNull(function);
        return list.stream()
                .sorted(Comparator.comparing(function))
                .collect(Collectors.toList());
    }
}
