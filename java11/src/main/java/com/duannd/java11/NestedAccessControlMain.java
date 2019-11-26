package com.duannd.java11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NestedAccessControlMain {

    public static void main(String[] args) throws Exception {
        System.out.println("----- Nested Based Access Control -----");
        reflectionPrivateMethod();
    }

    private static void reflectionPrivateMethod() throws NoSuchMethodException {
        var obj = new NestedAccessControl();
        try {
            Method privateMethod = NestedAccessControl.class.getDeclaredMethod("myPrivate");
            privateMethod.invoke(obj);
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
        var nestHost = NestedAccessControl.class.getNestHost();
        System.out.println("Host Class: " + nestHost.getName());
        for (Class<?> c : nestHost.getNestMembers()) {
            var isNested = c.isNestmateOf(NestedAccessControl.Nested.class);
            var message = String.format("Classes %s is nest mate of NestedAccessControl? %s", c.getName(), isNested);
            System.out.println(message);
        }
    }

}
