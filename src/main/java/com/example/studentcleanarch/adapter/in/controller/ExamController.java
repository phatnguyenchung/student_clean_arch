package com.example.studentcleanarch.adapter.in.controller;

import com.example.studentcleanarch.adapter.in.dto.request.exam.CreateExamRequest;
import com.example.studentcleanarch.adapter.in.dto.request.exam.UpdateExamRequest;
import com.example.studentcleanarch.adapter.in.dto.response.ApiResponse;
import com.example.studentcleanarch.application.port.in.exam.CreateExamUseCase;
import com.example.studentcleanarch.application.port.in.exam.UpdateExamUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/exam", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExamController {
    private final CreateExamUseCase createExamUseCase;
    private final UpdateExamUseCase updateExamUseCase;

    @PostMapping
    public ApiResponse<?> create(@RequestBody CreateExamRequest createExamRequest) {
        return ApiResponse.success(createExamUseCase.createExam(createExamRequest.toCommand()));
    }

    @PutMapping
    public ApiResponse<?> update(@RequestBody UpdateExamRequest updateExamRequest) {
        return ApiResponse.success(updateExamUseCase.updateExam(updateExamRequest.toCommand()));
    }

}
