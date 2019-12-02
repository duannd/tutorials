package com.duannd.java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeApiMain {

    private static final Logger log = LoggerFactory.getLogger(DateTimeApiMain.class);
    // init variable
    private static final ZoneId LOCAL_ZONE = ZoneId.of("+07:00");
    private static final ZoneId US_ZONE = ZoneId.of("-08:00");
    private static final ZoneId UTC_ZONE = ZoneOffset.UTC;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");

    public static void main(String[] args) {
        Java8Utils.printHeader("LocalDate examples");
        localDateExamples();
        Java8Utils.printHeader("LocalTime examples");
        localTimeExamples();
        Java8Utils.printHeader("LocalDateTime examples");
        localDateTimeExamples();
        Java8Utils.printHeader("ZonedDateTime examples");
        zonedDateTimeExamples();
        Java8Utils.printHeader("OffsetDateTime examples");
        offsetDateTimeExamples();
        Java8Utils.printHeader("Instant examples");
        instantExamples();
    }

    private static void instantExamples() {
        // Creation instance {now, from, of)
        Instant utc = Instant.now(); // utc timezone
        Instant local = Instant.now(Clock.system(ZoneId.of("Asia/Bangkok")));
        log.info("UTC   instant {}, time-millis {}", utc, utc.toEpochMilli());
        log.info("Local instant {}, time-millis {}", local, local.toEpochMilli());
    }

    private static void offsetDateTimeExamples() {
        OffsetDateTime localNow = OffsetDateTime.now();
        OffsetDateTime utcNow = OffsetDateTime.now(ZoneOffset.UTC);
        log.info("Current local ZonedDateTime: {}", localNow);
        log.info("Current utc ZonedDateTime: {}", utcNow);
        log.info("OffsetDateTime to Instant: {} to {}", utcNow, utcNow.toInstant());
        log.info("OffsetDateTime to ZonedDateTime: {} to {}", localNow, localNow.toZonedDateTime());
        log.info("OffsetDateTime to ZonedDateTime same instant: {} to {}", localNow, localNow.atZoneSameInstant(ZoneOffset.UTC)); // can change offset
        log.info("OffsetDateTime to ZonedDateTime similar local: {} to {}", localNow, localNow.atZoneSimilarLocal(ZoneOffset.UTC));
    }

    private static void zonedDateTimeExamples() {
        ZonedDateTime localNow = ZonedDateTime.now();
        ZonedDateTime utcNow = ZonedDateTime.now(UTC_ZONE);
        log.info("Current local ZonedDateTime: {}", localNow);
        log.info("Current utc ZonedDateTime: {}", utcNow);
        log.info("ZonedDateTime to Instant: {} to {}", utcNow, utcNow.toInstant());
        log.info("ZonedDateTime to OffsetDateTime: {} to {}", localNow, localNow.toOffsetDateTime()); // can not change offset
        log.info("ZonedDateTime to ZonedDateTime same instant: {} to {}", utcNow, utcNow.withZoneSameInstant(LOCAL_ZONE)); // same instant is same Instant
        log.info("ZonedDateTime to ZonedDateTime same local: {} to {}", utcNow, utcNow.withZoneSameLocal(LOCAL_ZONE)); // same local is localDateTime
        log.info("ZonedDateTime to Fixed ZonedDateTime {} to {}", utcNow, utcNow.withFixedOffsetZone());
    }

    private static void localDateTimeExamples() {
        // Local DateTime only LocalDate & LocalTime.
        LocalDateTime today = LocalDateTime.now();
        log.info("Current Local date-time: {}", today);
        log.info("Current UTC date-time: {}", LocalDateTime.now(UTC_ZONE));
        log.info("Current US date-time: {}", LocalDateTime.now(US_ZONE));
        LocalDateTime utcDateTime = LocalDateTime.of(LocalDate.now(UTC_ZONE), LocalTime.of(18, 0));
        log.info("Current UTC date-time from: {}", utcDateTime);
        log.info("date-time format: {}", utcDateTime.format(DATE_TIME_FORMATTER));
        log.info("utc to local ZonedDateTime: {} to {}", utcDateTime, utcDateTime.atZone(LOCAL_ZONE));
        log.info("utc to local OffsetDateTime: {} to {}", utcDateTime, utcDateTime.atOffset((ZoneOffset) LOCAL_ZONE));
        log.info("utc {} truncated to: {}", utcDateTime, utcDateTime.truncatedTo(ChronoUnit.HOURS));
        log.info("unix time of local: {}", today.toInstant((ZoneOffset) LOCAL_ZONE).toEpochMilli());
        log.info("unix time of UTC: {}", today.toInstant((ZoneOffset) UTC_ZONE).toEpochMilli());
        log.info("unix time of US: {}", today.toInstant((ZoneOffset) US_ZONE).toEpochMilli());
    }

    private static void localTimeExamples() {
        // current time at local timezone
        LocalTime localNow = LocalTime.now();
        log.info("Current local-time: {}", localNow);
        // current utc time
        log.info("Current utc time: {}", LocalTime.now(UTC_ZONE));
        // current us time
        log.info("Current UTC-8 time: {}", LocalTime.now(US_ZONE));
        // Noon time
        log.info("NOON time: {}", LocalTime.NOON);
        // midnight time
        log.info("Midnight time: {}", LocalTime.MIDNIGHT);
        // 6h PM today
        log.info("6h PM today: {}", LocalTime.of(18, 0, 0)); // based on zero index
        log.info("6h PM today: {}", LocalTime.ofSecondOfDay(18 * 60 * 60));
        // format time
        log.info("Current format time: {}", LocalTime.now().format(TIME_FORMATTER));
    }

    private static void localDateExamples() {
        // current date at local timezone (utc+7)
        LocalDate localNow = LocalDate.now();
        log.info("Current Date: {}", localNow);
        // current date at utc timezone
        log.info("Current Date of UTC: {}", LocalDate.now(UTC_ZONE));
        // current date at us timezone.
        log.info("Current Date of GMT-8: {}", LocalDate.now(US_ZONE));
        // find first day of 2019
        log.info("First Day of 2019: {}", LocalDate.of(2019, 1, 1));
        // find by days from 01/01/1970
        log.info("365th from 01/01/1970: {}", LocalDate.ofEpochDay(365)); // start 0.
        // find by year-day.
        log.info("33th in 2019: {}", LocalDate.ofYearDay(2019, 33)); //  from 1 to 366
        // format date
        log.info("Format date from yyyy-MM-dd to dd/MM/yyyy: {}", LocalDate.now().format(DATE_FORMATTER));
    }

}
