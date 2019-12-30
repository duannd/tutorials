package com.duannd.core.regex;

public class CapturingGroupTest {

    private static final String EMAIL_PATTERN = "^([a-zA-Z0-9.]+)([+]?)([0-9a-zA-Z]*)@([a-z]+)(\\.[a-z]+)*(\\.[a-z]{2,3})$";

    public static void main(String[] args) {
        emailPattern();
    }

    private static void emailPattern() {
        log("duan.nguyen@formos.com");
        log("duan.nguyen12343@formos.com");
        log("duan.nguyen+01@formos.com");
        log("duan.nguyen+01@formos.com.vn");
        log("duan.nguyen+01@formos.");
        log("duan.nguyen+01@.com");
        log("duan.nguyen@formos..com");
        log("duan.nguyen@formos1.com");
        log("duan.nguyen");
        log("duan-nguyen@formos.com");
        log("duan_nguyen@formos.com");
        log("duan.nguyen@formos.comduan.nguyen@formos.com");
    }

    private static void log(String email) {
        String message = String.format("%s when validate %s", email.matches(EMAIL_PATTERN) ,email);
        System.out.println(message);
    }

}
