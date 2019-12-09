package com.duannd.patterns.creational.singleton;

import com.duannd.patterns.creational.singleton.models.EagerInitializedSingleton;
import com.duannd.patterns.utils.DesignPatternUtils;

public class SingletonMain {

    public static void main(String[] args) {
        DesignPatternUtils.printHeader("Eager Initialization");
        eagerInitialization();
    }

    private static void eagerInitialization() {
        System.out.println(EagerInitializedSingleton.getInstance());
    }

}
