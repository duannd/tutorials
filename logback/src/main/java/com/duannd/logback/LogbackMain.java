package com.duannd.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created By ngdduan@gmail.com at 12/1/19 12:48 PM
 */
public class LogbackMain {

    private static final Logger log = LoggerFactory.getLogger(LogbackMain.class);

    public static void main(String[] args) {
        log.info("test logback");
    }

}
