package com.duannd.java9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.duannd.java9.Java9Utils.NAMES;

public class FactoryMethodsMain {

    private static final Logger log = LoggerFactory.getLogger(FactoryMethodsMain.class);


    public static void main(String[] args) {
        Java9Utils.printHeader("Factory Methods for Immutable List");
        immutableList();
        Java9Utils.printHeader("Factory Methods for Immutable Set");
        immutableSet();
        Java9Utils.printHeader("Factory Methods for Immutable Map and Map.Entry");
        immutableMap();
    }

    private static void immutableMap() {
        log.info("Empty Map {}", Map.of());
        log.info("Non Empty Map {}", Map.of(NAMES[0], NAMES[0], NAMES[1], NAMES[1]));
        log.info("Non Empty Map of Entry {}", Map.ofEntries(
                Map.entry(NAMES[0], NAMES[0]), Map.entry(NAMES[2], NAMES[3])
        ));
    }

    private static void immutableSet() {
        log.info("Empty Set: {}", Set.of());
        log.info("Non Empty Set: {}", Set.of(Java9Utils.NAMES)); // not allow duplicate
        log.info("Non Empty Set with Array Type: {}", Set.<String[]>of(Java9Utils.NAMES)); // Set of arrays.
    }

    private static void immutableList() {
        List<String> emptyList = List.of();
        log.info("Empty List: {}", emptyList);
        List<String> nonEmptyList = List.of(Java9Utils.NAMES);
        log.info("Non Empty List: {}", nonEmptyList);
    }


}
