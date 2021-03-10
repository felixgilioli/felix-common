package com.felix.common.collection;

/**
 * Class that contains methods for working with arrays.
 */
public class Arrays {

    /**
     * Contains the obj in array.
     * @param array array with objects.
     * @param obj object to filter in array.
     * @param <T> generic type of objects.
     * @return true if array contains obj, false if doesn't contains.
     */
    public static <T> boolean contains(T[] array, T obj) {
        for (T o : array) {
            if (o.equals(obj))
                return true;
        }
        return false;
    }

    /**
     * Contains the obj in array.
     * @param array array with ints.
     * @param obj int to filter in array.
     * @return true if array contains obj, false if doesn't contains.
     */
    public static boolean contains(int[] array, int obj) {
        for (int o : array) {
            if (o == obj)
                return true;
        }
        return false;
    }

    /**
     * Contains the obj in array.
     * @param array array with ints.
     * @param obj long to filter in array.
     * @return true if array contains obj, false if doesn't contains.
     */
    public static boolean contains(long[] array, long obj) {
        for (long o : array) {
            if (o == obj)
                return true;
        }
        return false;
    }

    /**
     * Contains the obj in array.
     * @param array array with ints.
     * @param obj char to filter in array.
     * @return true if array contains obj, false if doesn't contains.
     */
    public static boolean contains(char[] array, char obj) {
        for (char o : array) {
            if (o == obj)
                return true;
        }
        return false;
    }

    /**
     * Contains the obj in array.
     * @param array array with ints.
     * @param obj double to filter in array.
     * @return true if array contains obj, false if doesn't contains.
     */
    public static boolean contains(double[] array, double obj) {
        for (double o : array) {
            if (o == obj)
                return true;
        }
        return false;
    }

    /**
     * Contains the obj in array.
     * @param array array with ints.
     * @param obj float to filter in array.
     * @return true if array contains obj, false if doesn't contains.
     */
    public static boolean contains(float[] array, float obj) {
        for (float o : array) {
            if (o == obj)
                return true;
        }
        return false;
    }
}
