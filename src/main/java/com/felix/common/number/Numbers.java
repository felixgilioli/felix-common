package com.felix.common.number;

/**
 * Class that contains methods for working with {@link Number}.
 */
public class Numbers {

    /**
     * Returns zero if number is null.
     * @param value number.
     * @return zero if number is null.
     */
    public static Number zeroIfNull(Number value) {
        return value != null ? value : 0;
    }

}
