package com.example.studentcleanarch.adapter.in.controller;

import com.example.studentcleanarch.adapter.in.dto.request.CreateStudentRequest;
import com.example.studentcleanarch.adapter.in.dto.request.DeleteStudentRequest;
import com.example.studentcleanarch.adapter.in.dto.request.UpdateStudentRequest;
import com.example.studentcleanarch.adapter.in.dto.response.ApiResponse;
import com.example.studentcleanarch.application.port.in.CreateStudentUseCase;
import com.example.studentcleanarch.application.port.in.DeleteStudentUseCase;
import com.example.studentcleanarch.application.port.in.GetStudentUseCase;
import com.example.studentcleanarch.application.port.in.UpdateStudentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    private final CreateStudentUseCase createStudentUseCase;
    private final UpdateStudentUseCase updateStudentUseCase;
    private final GetStudentUseCase getStudentUseCase;
    private final DeleteStudentUseCase deleteStudentUseCase;

    @PostMapping
    public ApiResponse<?> create(@RequestBody CreateStudentRequest createStudentRequest) {
        return ApiResponse.success(createStudentUseCase.createStudent(createStudentRequest.toCommand()));
    }

    @PutMapping
    public ApiResponse<?> update(@RequestBody UpdateStudentRequest updateStudentRequest){
        return  ApiResponse.success(updateStudentUseCase.updateStudent(updateStudentRequest.toCommand()));
    }

    @GetMapping
    public ApiResponse<?> get(){
        return  ApiResponse.success(getStudentUseCase.getAllStudent());
    }

    @DeleteMapping
    public ApiResponse<?> delete(@RequestBody DeleteStudentRequest deleteStudentRequest){
        return  ApiResponse.success(deleteStudentUseCase.deleteStudent(deleteStudentRequest.getId()));
    }
}
