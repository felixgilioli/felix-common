package com.felix.common.number;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.util.Objects.requireNonNull;

/**
 * Class that contains methods for working with {@link BigDecimal}.
 */
public class BigDecimals {

    /**
     * Instance of BigDecimal with one hundred value.
     */
    public static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    /**
     * Returns zero if BigDecimal is null.
     * @param bd BigDecimal.
     * @return zero if BigDecimal is null.
     */
    public static BigDecimal zeroIfNull(BigDecimal bd) {
        return bd == null ? BigDecimal.ZERO : bd;
    }

    /**
     * Returns null if BigDecimal is zero.
     * @param bd BigDecimal.
     * @return null if BigDecimal is zero.
     */
    public static BigDecimal nullIfZero(BigDecimal bd) {
        if (bd == null)
            return null;

        return bd.compareTo(BigDecimal.ZERO) == 0 ? null : bd;
    }

    /**
     * Truncate the BigDecimal.
     * @param bd BigDecimal.
     * @param places places to truncate.
     * @return a new instance of truncated {@link BigDecimal}.
     */
    public static BigDecimal truncate(BigDecimal bd, int places) {
        requireNonNull(bd);
        return bd.setScale(places, RoundingMode.DOWN);
    }

    /**
     * Return a value of percent.
     * @param value value.
     * @param percent percent.
     * @return value of percent.
     */
    public static BigDecimal percent(BigDecimal value, BigDecimal percent) {
        requireNonNull(value);
        requireNonNull(percent);
        return value.multiply(percent).divide(ONE_HUNDRED);
    }

    /**
     * adds a percent in a BigDecimal.
     * @param value value.
     * @param percent percent.
     * @return a new instance of {@link BigDecimal} with adds percent.
     */
    public static BigDecimal addPercent(BigDecimal value, BigDecimal percent) {
        requireNonNull(value);
        requireNonNull(percent);
        return value.add(value.multiply(percent).divide(ONE_HUNDRED));
    }

    /**
     * subtracts a percent in a BigDecimal.
     * @param value value.
     * @param percent percent.
     * @return a new instance of {@link BigDecimal} with subtracted percent.
     */
    public static BigDecimal subtractPercent(BigDecimal value, BigDecimal percent) {
        requireNonNull(value);
        requireNonNull(percent);
        return value.subtract(value.multiply(percent).divide(ONE_HUNDRED));
    }
}
