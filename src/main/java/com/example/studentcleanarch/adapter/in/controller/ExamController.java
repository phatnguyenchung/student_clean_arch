package com.example.studentcleanarch.adapter.in.controller;

import com.example.studentcleanarch.adapter.in.dto.request.exam.CreateExamRequest;
import com.example.studentcleanarch.adapter.in.dto.response.ApiResponse;
import com.example.studentcleanarch.application.port.in.exam.CreateExamUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/exam", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExamController {
    private final CreateExamUseCase createExamUseCase;

    @PostMapping
    public ApiResponse<?> create(@RequestBody CreateExamRequest createExamRequest) {
        return ApiResponse.success(createExamUseCase.createExam(createExamRequest.toCommand()));
    }
}
