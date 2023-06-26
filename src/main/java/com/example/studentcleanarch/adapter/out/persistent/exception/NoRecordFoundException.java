package com.example.studentcleanarch.adapter.out.persistent.exception;

public class NoRecordFoundException extends DataAccessException {
    public NoRecordFoundException() {}

    public NoRecordFoundException(String message) {
        super(message);
    }

    public NoRecordFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
