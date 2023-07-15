package com.example.studentcleanarch.application.holder;

public class LogRefIdHolder {
    private static final ThreadLocal<String> refId = new ThreadLocal<>();

    public static String get() {
        return refId.get();
    }

    public static void set(String value) {
        refId.set(value);
    }
}
