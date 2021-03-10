package com.felix.common.bool;

/**
 * Class that contains methods for working with {@link Boolean}.
 */
public class Booleans {

    /**
     * Returns Boolean.FALSE if b is null.
     * @param b boolean.
     * @return Boolean.FALSE if b is null.
     */
    public static Boolean falseIfNull(Boolean b) {
        return b == null ? Boolean.FALSE : b;
    }
}
