package com.ibm.business.buyer.message;

import org.apache.logging.log4j.Level;

public enum MessageLevel {
    I(Level.INFO), W(Level.WARN), E(Level.ERROR);

    private Level log4jLevel;

    private MessageLevel(Level level) {
        this.log4jLevel = level;
    }

    public Level getLog4JLevel() {
        return log4jLevel;
    }
}
