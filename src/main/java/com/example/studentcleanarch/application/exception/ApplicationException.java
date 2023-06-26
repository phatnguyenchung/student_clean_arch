package com.example.studentcleanarch.application.exception;

import com.example.studentcleanarch.common.TimoException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApplicationException extends TimoException {
    public ApplicationException(String message) {
        super(message);
    }
}
