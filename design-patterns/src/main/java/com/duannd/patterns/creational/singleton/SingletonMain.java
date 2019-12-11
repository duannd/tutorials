package com.duannd.patterns.creational.singleton;

import com.duannd.patterns.creational.singleton.models.EagerInitializedSingleton;
import com.duannd.patterns.creational.singleton.models.LazyInitializedSingleton;
import com.duannd.patterns.creational.singleton.models.StaticBlockInitializedSingleton;
import com.duannd.patterns.creational.singleton.models.ThreadSafeSingleton;
import com.duannd.patterns.utils.DesignPatternUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonMain {

    public static void main(String[] args) {
        DesignPatternUtils.printHeader("Eager Initialization");
        eagerInitialization();
        DesignPatternUtils.printHeader("Static Block Initialization");
        staticBlockInitialization();
        DesignPatternUtils.printHeader("Lazy Initialization");
        lazyInitialization();
        DesignPatternUtils.printHeader("Thread Safe Singleton");
        threadSafeSingleton();
    }

    private static void threadSafeSingleton() {
        int maxThread = 10;
        ExecutorService executor = Executors.newFixedThreadPool(maxThread);
        for (int i = 0; i < maxThread; i++) {
            executor.execute(() -> ThreadSafeSingleton.getInstance().log());
        }
        executor.shutdown();
    }

    private static void lazyInitialization() {
        System.out.println(LazyInitializedSingleton.getInstance());
        System.out.println(LazyInitializedSingleton.getInstance());
    }

    private static void staticBlockInitialization() {
        System.out.println(StaticBlockInitializedSingleton.getInstance());
    }

    private static void eagerInitialization() {
        System.out.println(EagerInitializedSingleton.getInstance());
    }

}
