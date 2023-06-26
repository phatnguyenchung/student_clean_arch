package com.example.studentcleanarch.adapter.in.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.example.studentcleanarch.domain.ErrorCode;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean success;

    @With
    private Integer code;

    private String readableCode;
    private String message;
    private T data;
    private Object secData;

    public static <T> ApiResponse<T> success() {
        return (ApiResponse<T>)
                ApiResponse.builder().success(true).code(ErrorCode.SUCCESS).build();
    }

    public static <T> ApiResponse<T> success(T data) {
        return (ApiResponse<T>) ApiResponse.builder()
                .code(ErrorCode.SUCCESS)
                .success(true)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> success(int code, T data) {
        return (ApiResponse<T>)
                ApiResponse.builder().success(true).code(code).data(data).build();
    }

    public static <T> ApiResponse<T> success(int code, T data, Object secData) {
        return (ApiResponse<T>) ApiResponse.builder()
                .success(true)
                .code(code)
                .data(data)
                .secData(secData)
                .build();
    }

    public static <T> ApiResponse<T> failure(int code) {
        return (ApiResponse<T>) ApiResponse.builder().success(false).code(code).build();
    }

    public static <T> ApiResponse<T> failure(int code, String message) {
        return (ApiResponse<T>)
                ApiResponse.builder().success(false).code(code).message(message).build();
    }

    public static <T> ApiResponse<T> failure(int code, String message, Object data) {
        return (ApiResponse<T>) ApiResponse.builder()
                .success(false)
                .code(code)
                .message(message)
                .data(data)
                .build();
    }

    @JsonIgnore
    public boolean isSuccessCode() {
        return "SUCCESS".equalsIgnoreCase(readableCode);
    }
}
