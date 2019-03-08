package com.duannd.core.regex;

import java.util.regex.Pattern;

/**
 * Created By duan.nd@senseinfosys.com at 3/8/2019 2:23 PM
 * @see "https://www.journaldev.com/634/regular-expression-in-java-regex-example"
 */
public class RegexMain {

    public static void main(String[] args) {
        var pattern = Pattern.compile("default_[a-z]+_w1");
        System.out.println("default_cus_w1: " + pattern.matcher("default_cus_w1").matches());
        System.out.println("a_cus_w1: " + pattern.matcher("a_cus_w1").matches());
        System.out.println("default_cus_w: " + pattern.matcher("default_cus_w").matches());
        System.out.println("_cus_: " + pattern.matcher("_cus_").matches());
        System.out.println("a: " + pattern.matcher("a").matches());
        System.out.println("" + (32000000 / 23265));
    }

}
