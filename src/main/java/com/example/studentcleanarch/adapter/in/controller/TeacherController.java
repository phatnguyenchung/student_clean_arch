package com.example.studentcleanarch.adapter.in.controller;

import com.example.studentcleanarch.adapter.in.dto.request.teacher.CreateTeacherRequest;
import com.example.studentcleanarch.adapter.in.dto.request.teacher.UpdateTeacherRequest;
import com.example.studentcleanarch.adapter.in.dto.response.ApiResponse;
import com.example.studentcleanarch.application.port.in.teacher.CreateTeacherUseCase;
import com.example.studentcleanarch.application.port.in.teacher.UpdateTeacherUseCase;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/teacher", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeacherController {

    private final CreateTeacherUseCase createTeacherUseCase;
    private final UpdateTeacherUseCase updateTeacherUseCase;

    @PostMapping
    public ApiResponse<?> create(@RequestBody CreateTeacherRequest createTeacherRequest) {
        return ApiResponse.success(createTeacherUseCase.createTeacher(createTeacherRequest.toCommand()));
    }

    @PutMapping
    public ApiResponse<?> update(@RequestBody UpdateTeacherRequest updateTeacherRequest) {
        return ApiResponse.success(updateTeacherUseCase.updateTeacher(updateTeacherRequest.toCommand()));
    }
}
