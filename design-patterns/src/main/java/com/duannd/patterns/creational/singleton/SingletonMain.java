package com.duannd.patterns.creational.singleton;

import com.duannd.patterns.creational.singleton.models.EagerInitializedSingleton;
import com.duannd.patterns.creational.singleton.models.StaticBlockInitializedSingleton;
import com.duannd.patterns.utils.DesignPatternUtils;

public class SingletonMain {

    public static void main(String[] args) {
        DesignPatternUtils.printHeader("Eager Initialization");
        eagerInitialization();
        DesignPatternUtils.printHeader("Static Block Initialization");
        staticBlockInitialization();
    }

    private static void staticBlockInitialization() {
        System.out.println(StaticBlockInitializedSingleton.getInstance());
    }

    private static void eagerInitialization() {
        System.out.println(EagerInitializedSingleton.getInstance());
    }

}
