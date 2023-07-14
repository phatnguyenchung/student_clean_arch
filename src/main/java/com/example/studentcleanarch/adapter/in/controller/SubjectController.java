package com.example.studentcleanarch.adapter.in.controller;

import com.example.studentcleanarch.adapter.in.dto.request.subject.CreateSubjectRequest;
import com.example.studentcleanarch.adapter.in.dto.request.subject.UpdateSubjectRequest;
import com.example.studentcleanarch.adapter.in.dto.response.ApiResponse;
import com.example.studentcleanarch.application.port.in.subject.CreateSubjectUseCase;
import com.example.studentcleanarch.application.port.in.subject.UpdateSubjectUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/subject", produces = MediaType.APPLICATION_JSON_VALUE)
public class SubjectController {

    private final CreateSubjectUseCase createSubjectUseCase;
    private final UpdateSubjectUseCase updateSubjectUseCase;

    @PostMapping
    public ApiResponse<?> create(@RequestBody CreateSubjectRequest createSubjectRequest) {
        return ApiResponse.success(createSubjectUseCase.createSubject(createSubjectRequest.toCommand()));
    }

    @PutMapping
    public ApiResponse<?> update(@RequestBody UpdateSubjectRequest updateSubjectRequest) {
        return ApiResponse.success(updateSubjectUseCase.updateSubject(updateSubjectRequest.toCommand()));
    }
}
