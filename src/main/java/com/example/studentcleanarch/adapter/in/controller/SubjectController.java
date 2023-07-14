package com.example.studentcleanarch.adapter.in.controller;

import com.example.studentcleanarch.adapter.in.dto.request.subject.CreateSubjectRequest;
import com.example.studentcleanarch.adapter.in.dto.request.subject.DeleteSubjectRequest;
import com.example.studentcleanarch.adapter.in.dto.request.subject.UpdateSubjectRequest;
import com.example.studentcleanarch.adapter.in.dto.response.ApiResponse;
import com.example.studentcleanarch.application.port.in.subject.CreateSubjectUseCase;
import com.example.studentcleanarch.application.port.in.subject.DeleteSubjectUseCase;
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
    private final DeleteSubjectUseCase deleteSubjectUseCase;

    @PostMapping
    public ApiResponse<?> create(@RequestBody CreateSubjectRequest createSubjectRequest) {
        return ApiResponse.success(createSubjectUseCase.createSubject(createSubjectRequest.toCommand()));
    }

    @PutMapping
    public ApiResponse<?> update(@RequestBody UpdateSubjectRequest updateSubjectRequest) {
        return ApiResponse.success(updateSubjectUseCase.updateSubject(updateSubjectRequest.toCommand()));
    }

    @DeleteMapping
    public ApiResponse<?> delete(@RequestBody DeleteSubjectRequest deleteSubjectRequest) {
        return ApiResponse.success(deleteSubjectUseCase.deleteSubject(deleteSubjectRequest.getId()));
    }
}
