package com.example.studentcleanarch.adapter.in.controller;

import com.example.studentcleanarch.adapter.in.dto.request.teacher.CreateTeacherRequest;
import com.example.studentcleanarch.adapter.in.dto.request.teacher.DeleteTeacherRequest;
import com.example.studentcleanarch.adapter.in.dto.request.teacher.UpdateTeacherRequest;
import com.example.studentcleanarch.adapter.in.dto.response.ApiResponse;
import com.example.studentcleanarch.application.port.in.teacher.CreateTeacherUseCase;
import com.example.studentcleanarch.application.port.in.teacher.DeleteTeacherUseCase;
import com.example.studentcleanarch.application.port.in.teacher.GetTeacherUseCase;
import com.example.studentcleanarch.application.port.in.teacher.UpdateTeacherUseCase;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/teacher", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeacherController {

    private final CreateTeacherUseCase createTeacherUseCase;
    private final UpdateTeacherUseCase updateTeacherUseCase;
    private final DeleteTeacherUseCase deleteTeacherUseCase;
    private final GetTeacherUseCase getTeacherUseCase;

    @PostMapping
    public ApiResponse<?> create(@RequestBody CreateTeacherRequest createTeacherRequest) {
        return ApiResponse.success(createTeacherUseCase.createTeacher(createTeacherRequest.toCommand()));
    }

    @PutMapping
    public ApiResponse<?> update(@RequestBody UpdateTeacherRequest updateTeacherRequest) {
        return ApiResponse.success(updateTeacherUseCase.updateTeacher(updateTeacherRequest.toCommand()));
    }

    @DeleteMapping
    public ApiResponse<?> delete(@RequestBody DeleteTeacherRequest deleteTeacherRequest) {
        return ApiResponse.success(deleteTeacherUseCase.deleteTeacher(deleteTeacherRequest.toCommand()));
    }

    @GetMapping
    public ApiResponse<?> get() {
        return ApiResponse.success(getTeacherUseCase.getAllTeacher());
    }

    @GetMapping("/getteacherbyid")
    public ResponseEntity<Object> getteacherbyid(@RequestParam Long id) {
        return new ResponseEntity<Object>(getTeacherUseCase.getTeacherById(id), HttpStatus.OK);
    }
}
