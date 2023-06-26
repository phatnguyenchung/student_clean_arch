package com.example.studentcleanarch.adapter.out.persistent.exception;

import com.example.studentcleanarch.common.TimoException;

public class DataAccessException extends TimoException {
    public DataAccessException() {}

    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
