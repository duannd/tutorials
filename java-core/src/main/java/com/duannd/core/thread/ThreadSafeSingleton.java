package com.duannd.core.thread;

/**
 * Created By ngdduan@gmail.com at 2019-02-22 00:25
 */
public class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton instance = null;
    private static final Object mutex = new Object();

    private ThreadSafeSingleton() {

    }

    public static ThreadSafeSingleton getInstance() {
        var result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new ThreadSafeSingleton();
            }
        }
        return result;
    }

}
