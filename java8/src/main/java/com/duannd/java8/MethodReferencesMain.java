package com.duannd.java8;

import com.duannd.java8.models.User;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MethodReferencesMain {

    public static void main(String[] args) {
        System.out.println("----- Method References -----");
        methodReferences();
    }

    private static void methodReferences() {
        List<String> names = Arrays.asList(null, "Duan Nguyen", "Trump", "   ", "Bill Gate");
        List<User> users = names.stream()
                // Reference to an Instance Method of an Object of a Particular Type
                .filter(Objects::nonNull)
                .filter(name -> !name.isEmpty())
                // Reference to a Constructor
                .map(User::new)
                // Reference to an Instance Method
                .filter(User::isRealUser)
                // Reference to a Static Method
                .filter(User::isLegalUser)
                // Collect to a List
                .collect(Collectors.toList());
        System.out.println(users);
    }


}
