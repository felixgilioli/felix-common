package com.felix.common.collection;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Class that contains methods for working with {@link Collection}.
 */
public class Collections {

    /**
     * Returns true if collection {@param c} is null or empty.
     * @param c collection.
     * @return true if collection {@param c} is null or empty.
     */
    public static boolean isNullOrEmpty(Collection<?> c) {
        return c == null || c.isEmpty();
    }

    /**
     * Contains any object with condition {@param predicate}.
     * @param c collection.
     * @param predicate condition.
     * @param <T> generic type of collection.
     * @return true if any object in collection has the condition.
     */
    public static <T> boolean anyMatch(Collection<T> c, Predicate<T> predicate) {
        return Objects.requireNonNull(c)
                .stream()
                .anyMatch(predicate);
    }

    /**
     * Argument to use in a filter method, for example:
     * <pre><code>
     * persons.stream().filter(distinctBy(Person::getName))
     * </code></pre>
     * @param keyExtractor returns the property to distinct.
     * @param <T> generic type of object.
     * @return {@link Predicate<T>} to use in a filter method.
     */
    public static <T> Predicate<T> distinctBy(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
