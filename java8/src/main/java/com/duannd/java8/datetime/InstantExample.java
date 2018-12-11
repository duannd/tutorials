package com.duannd.java8.datetime;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Created By ngdduan@gmail.com at 12/10/2018 4:15 PM
 */
public class InstantExample {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm.ss.SSS");

    public static void main(String[] args) {
        Instant utcInstant = Instant.now(Clock.system(ZoneId.of("+07:00")));
        System.out.println("UTC time: " + utcInstant.atZone(ZoneOffset.UTC).format(FORMATTER));
        // Convert from UTC to localDateTime
        System.out.println("HCM time: " + utcInstant.atZone(ZoneId.of("+07:00")).format(FORMATTER));
    }

}
