package com.felix.common.string;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * Class that contains methods for working with {@link String}.
 */
public class Strings {

    /**
     * Returns text with first letter uppercase, the rest of the lowercase text.
     * @param text text to capitalize.
     * @return capitalized text.
     */
    public static String capitalize(String text) {
        Objects.requireNonNull(text, "text is required.");

        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }

    /**
     * Returns text with first letter of each word uppercase.
     * @param text text to capitalize.
     * @return capitalized text.
     */
    public static String capitalizeAll(String text) {
        Objects.requireNonNull(text, "text is required.");

        return Arrays.stream(text.split(" "))
                .map(Strings::capitalize)
                .collect(Collectors.joining(" "));
    }

    /**
     * Returns a query text between percent(%).
     * @param query text query.
     * @return text with percent(%).
     */
    public static String formatToLike(String query) {
        requireNonNull(query);
        return '%' + query.toLowerCase() + '%';
    }

    /**
     * Returns a empty String if null.
     * @param value string.
     * @return empty String if null.
     */
    public static String emptyIfNull(String value) {
        return value != null ? value : "";
    }
}
