package com.duannd.patterns.creational.singleton;

import com.duannd.patterns.creational.singleton.models.*;
import com.duannd.patterns.utils.DesignPatternUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonMain {

    private static final Logger log = LoggerFactory.getLogger(SingletonMain.class);

    public static void main(String[] args) throws Exception {
        log.info("Singleton Tests running...............................................");
        DesignPatternUtils.printHeader("1. Eager Initialization");
        eagerInitialization();
        DesignPatternUtils.printHeader("2. Static Block Initialization");
        staticBlockInitialization();
        DesignPatternUtils.printHeader("3. Lazy Initialization");
        lazyInitialization();
        DesignPatternUtils.printHeader("4. Thread Safe Singleton");
        threadSafeSingleton();
        DesignPatternUtils.printHeader("5. Bill Pugh Singleton");
        billPughSingleton();
        DesignPatternUtils.printHeader("6. Using Reflection to destroy Singleton Pattern");
        destroySingletonPattern();
        DesignPatternUtils.printHeader("7. Enum Singleton");
        enumSingleton();
        DesignPatternUtils.printHeader("8. Serialization and Singleton");
        serializationAndSingleton();
    }

    private static void serializationAndSingleton() throws IOException, ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        objectOutput.writeObject(instanceOne);
        objectOutput.close();
        //deserialize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
        System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());
    }

    private static void enumSingleton() {
        EnumSingleton.log();
    }

    private static void destroySingletonPattern() throws Exception {
        EagerInitializedSingleton staticInstance = EagerInitializedSingleton.getInstance();
        // get no args constructor
        Constructor<EagerInitializedSingleton> constructor = EagerInitializedSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        EagerInitializedSingleton reflectionInstance = constructor.newInstance();
        System.out.println("staticInstance == reflectionInstance ? " + (staticInstance.hashCode() == reflectionInstance.hashCode()));
    }

    private static void billPughSingleton() {
        int maxThread = 30;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < maxThread; i++) {
            executorService.execute(() -> {
                BillPughSingleton.getInstance().log();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
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
