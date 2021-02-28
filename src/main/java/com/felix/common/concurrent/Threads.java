package com.felix.common.concurrent;

import static java.util.Objects.requireNonNull;

/**
 * Class that contains methods for working with {@link Thread}.
 */
public class Threads {

    /**
     * Run a command in another thread.
     * @param runnable command to run in a thread.
     * @return created thread.
     */
    public static Thread run(Runnable runnable) {
        requireNonNull(runnable);
        Thread thread = new Thread(runnable);
        thread.start();
        return thread;
    }

    /**
     * Execute Thread.sleep in a unchecked mode.
     * @param milliseconds time in milliseconds.
     */
    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
