package com.felix.common.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Strings {

    public static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static String capitalizeAll(String s) {
        return Arrays.stream(s.split(" "))
                .map(Strings::capitalize)
                .collect(Collectors.joining(" "));
    }
}
