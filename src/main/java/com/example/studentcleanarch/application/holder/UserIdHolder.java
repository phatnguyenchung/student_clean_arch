package com.example.studentcleanarch.application.holder;

public class UserIdHolder {
    private static final ThreadLocal<Long> refId = new ThreadLocal<>();

    public static Long get() {
        return refId.get();
    }

    public static void set(Long value) {
        refId.set(value);
    }
}
