package com.duannd.java8.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String fullName;
    private boolean real = true;

    public User(String fullName) {
        this.fullName = fullName;
    }

    public static boolean isRealUser(User u) {
        return u.real;
    }

    public boolean isLegalUser() {
        return real && fullName != null && !fullName.trim().isEmpty();
    }

    @Override
    public String toString() {
        return fullName;
    }
}
