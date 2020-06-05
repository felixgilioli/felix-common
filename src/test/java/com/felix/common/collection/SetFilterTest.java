package com.felix.common.collection;

import com.felix.common.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SetFilterTest {

    @Test
    void nextTest() {
        Set<Person> set = new HashSet<>(Arrays.asList(new Person(1, "tua"),
                new Person(2, "tia")));

        SetFilter<Person, Integer> setFilter = SetFilter.of(set)
                .compareWith(Person::getId);

        Optional<Person> next = setFilter.next(1);

        System.out.println(next.get());
    }
}
