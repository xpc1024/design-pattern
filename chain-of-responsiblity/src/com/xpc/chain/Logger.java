package com.xpc.chain;

public abstract class Logger {

    public static int DEBUG = 1;
    public static int INFO = 2;
    public static int ERROR = 3;

    protected int level;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    protected abstract void write(String msg);

    public void logMessage(int level, String msg) {
        if (this.level >= level) {
            write(msg);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, msg);
        }
    }
}
