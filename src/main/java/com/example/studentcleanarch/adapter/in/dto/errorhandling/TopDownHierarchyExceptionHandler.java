package com.example.studentcleanarch.adapter.in.dto.errorhandling;

import com.example.studentcleanarch.adapter.in.dto.response.ApiResponse;
import com.example.studentcleanarch.application.exception.ApplicationException;
import com.example.studentcleanarch.common.TimoException;
import com.example.studentcleanarch.domain.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@Slf4j
@RestControllerAdvice
public class TopDownHierarchyExceptionHandler {

    // global & unknown exception
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    protected ApiResponse<?> onUnknownException(Exception ex) {
        log.error("onUnknownException - {}", ex.getMessage(), ex);
        return ApiResponse.failure(ErrorCode.INTERNAL_ERROR);
    }

    // application layer
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ApplicationException.class)
    public ApiResponse<?> onApplicationException(ApplicationException ex) {
        log.error("onApplicationException - {}", ex.getMessage(), ex);
        return ApiResponse.failure(ErrorCode.INTERNAL_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TimoException.class)
    protected ApiResponse<?> onTimoException(TimoException ex) {
        log.error("onTimoException - {}", ex.getMessage(), ex);
        if (Objects.isNull(ex.getData())) {
            return ApiResponse.failure(ex.getCode(), ex.getMessage());
        }
        return ApiResponse.failure(ex.getCode(), ex.getMessage(), ex.getData());
    }
}
