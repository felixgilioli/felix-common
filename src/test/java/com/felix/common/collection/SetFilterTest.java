package com.felix.common.collection;

import com.felix.common.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetFilterTest {

    @Test
    void nextTest() {
        Set<Person> set = new HashSet<>(Arrays.asList(new Person(1, "Felix"),
                new Person(2, "Ricardo")));

        SetFilter<Person, Integer> setFilter = SetFilter.of(set)
                .compareWith(Person::getId);

        Optional<Person> next = setFilter.next(1);

        assertTrue(next.isPresent());
        assertEquals("Felix", next.get().getName());
    }
}
