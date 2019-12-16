package com.duannd.patterns.structural.adapter;

import com.duannd.patterns.utils.DesignPatternUtils;

public class AdapterPatternMain {

    public static void main(String[] args) {
        DesignPatternUtils.printHeader("Class Adapter Implementation");
        classAdapter();
        DesignPatternUtils.printHeader("Object Adapter Implementation");
        objectAdapter();
    }

    private static void objectAdapter() {
        SocketAdapter socketAdapter = new SocketObjectAdapterImpl();
        String convertMsg = "Object Adapter: 120V to %sV";
        System.out.println(String.format(convertMsg, socketAdapter.get120Volt().getVolts()));
        System.out.println(String.format(convertMsg, socketAdapter.get12Volt().getVolts()));
        System.out.println(String.format(convertMsg, socketAdapter.get3Volt().getVolts()));
    }

    private static void classAdapter() {
        SocketAdapter socketAdapter = new SocketAdapterImpl();
        String convertMsg = "Class Adapter: 120V to %sV";
        System.out.println(String.format(convertMsg, socketAdapter.get120Volt().getVolts()));
        System.out.println(String.format(convertMsg, socketAdapter.get12Volt().getVolts()));
        System.out.println(String.format(convertMsg, socketAdapter.get3Volt().getVolts()));
    }

}
