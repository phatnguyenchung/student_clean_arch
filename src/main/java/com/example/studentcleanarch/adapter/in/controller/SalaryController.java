package com.example.studentcleanarch.adapter.in.controller;


import com.example.studentcleanarch.adapter.in.dto.request.salary.CreateSalaryRequest;
import com.example.studentcleanarch.adapter.in.dto.request.salary.DeleteSalaryRequest;
import com.example.studentcleanarch.adapter.in.dto.request.salary.UpdateSalaryRequest;
import com.example.studentcleanarch.adapter.in.dto.response.ApiResponse;
import com.example.studentcleanarch.application.port.in.salary.CreateSalaryUseCase;
import com.example.studentcleanarch.application.port.in.salary.DeleteSalaryUseCase;
import com.example.studentcleanarch.application.port.in.salary.GetSalaryUseCase;
import com.example.studentcleanarch.application.port.in.salary.UpdateSalaryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/salary", produces = MediaType.APPLICATION_JSON_VALUE)
public class SalaryController {

    private final CreateSalaryUseCase createSalaryUseCase;
    private final UpdateSalaryUseCase updateSalaryUseCase;
    private final DeleteSalaryUseCase deleteSalaryUseCase;
    private final GetSalaryUseCase getSalaryUseCase;

    @PostMapping
    public ApiResponse<?> create(@RequestBody CreateSalaryRequest createSalaryRequest) {
        return ApiResponse.success(createSalaryUseCase.createSalary(createSalaryRequest.toCommand()));
    }

    @PutMapping
    public ApiResponse<?> update(@RequestBody UpdateSalaryRequest updateSalaryRequest) {
        return ApiResponse.success(updateSalaryUseCase.updateSalary(updateSalaryRequest.toCommand()));
    }

    @DeleteMapping
    public ApiResponse<?> delete(@RequestBody DeleteSalaryRequest deleteSalaryRequest) {
        return ApiResponse.success(deleteSalaryUseCase.deleteSalary(deleteSalaryRequest.toCommand()));
    }

    @GetMapping
    public ApiResponse<?> get() {
        return ApiResponse.success(getSalaryUseCase.getAllSalary());
    }

    @GetMapping("/getsalarybyid")
    public ResponseEntity<Object> getsalarybyid(@RequestParam Long id) {
        return new ResponseEntity<>(getSalaryUseCase.getSalaryById(id), HttpStatus.OK);
    }
}
