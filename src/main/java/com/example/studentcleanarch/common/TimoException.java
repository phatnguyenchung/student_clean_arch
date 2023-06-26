package com.example.studentcleanarch.common;

import lombok.Getter;

@Getter
public class TimoException extends RuntimeException {
    private int code;
    private Object data;

    public TimoException() {}

    public TimoException(String message) {
        super(message);
    }

    public TimoException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimoException(int code, String message, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }
}
