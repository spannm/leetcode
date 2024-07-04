package io.github.spannm.leetcode.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractTool {

    static {
        // configure the slf4j-simple static logger binding
        String prefix = "org.slf4j.simpleLogger.";
        System.setProperty(prefix + "logFile", "System.out");
        System.setProperty(prefix + "defaultLogLevel", "info");
        System.setProperty(prefix + "showShortLogName", "true");
        System.setProperty(prefix + "showDateTime", "true");
        System.setProperty(prefix + "dateTimeFormat", "yyyy-MM-dd HH:mm:ss.SSS");
        System.setProperty(prefix + "showThreadName", "false");
    }

    private final Logger logger;

    protected AbstractTool() {
        logger = LoggerFactory.getLogger(getClass().getSimpleName());
    }

    protected Logger getLogger() {
        return logger;
    }

}
