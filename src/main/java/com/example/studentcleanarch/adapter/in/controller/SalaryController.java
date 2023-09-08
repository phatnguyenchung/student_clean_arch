package com.example.studentcleanarch.adapter.in.controller;


import com.example.studentcleanarch.adapter.in.dto.request.salary.CreateSalaryRequest;
import com.example.studentcleanarch.adapter.in.dto.response.ApiResponse;
import com.example.studentcleanarch.application.port.in.salary.CreateSalaryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/salary", produces = MediaType.APPLICATION_JSON_VALUE)
public class SalaryController {

    private final CreateSalaryUseCase createSalaryUseCase;

    @PostMapping
    public ApiResponse<?> create(@RequestBody CreateSalaryRequest createSalaryRequest) {
        return ApiResponse.success(createSalaryUseCase.createSalary(createSalaryRequest.toCommand()));
    }

}
