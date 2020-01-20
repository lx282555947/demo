package com.lixin.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogback {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger("TestLogback");
        logger.debug("Hello world.");
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }
}
