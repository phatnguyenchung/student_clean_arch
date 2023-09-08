package com.example.studentcleanarch.adapter.in.controller;


import com.example.studentcleanarch.adapter.in.dto.request.salary.CreateSalaryRequest;
import com.example.studentcleanarch.adapter.in.dto.request.salary.DeleteSalaryRequest;
import com.example.studentcleanarch.adapter.in.dto.request.salary.UpdateSalaryRequest;
import com.example.studentcleanarch.adapter.in.dto.response.ApiResponse;
import com.example.studentcleanarch.application.port.in.salary.*;
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
    private final SearchSalaryUseCase searchSalaryUseCase;
    private final SortSalaryUseCase sortSalaryUseCase;

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

    @GetMapping("/searchbysalary")
    public ResponseEntity<Object> searchbysalary(@RequestParam int salary) {
        return new ResponseEntity<>(searchSalaryUseCase.searchBySalary(salary), HttpStatus.OK);
    }

    @GetMapping("/searchbyteacherid")
    public ResponseEntity<Object> searchbyteacherid(@RequestParam Long teacherId) {
        return new ResponseEntity<>(searchSalaryUseCase.searchByTeacherId(teacherId), HttpStatus.OK);
    }

    @GetMapping("/sortsalarybyiddesc")
    public ResponseEntity<Object> sortsalarybyiddesc() {
        return new ResponseEntity<>(sortSalaryUseCase.sortByIdDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortsalarybyidasc")
    public ResponseEntity<Object> sortsalarybyidasc() {
        return new ResponseEntity<>(sortSalaryUseCase.sortByIdAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortsalarybyteacheriddesc")
    public ResponseEntity<Object> sortsalarybyteacheriddesc() {
        return new ResponseEntity<>(sortSalaryUseCase.sortByTeacherIdDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortsalarybyteacheridasc")
    public ResponseEntity<Object> sortsalarybyteacheridasc() {
        return new ResponseEntity<>(sortSalaryUseCase.sortByTeacherIdAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortsalarybysalarydesc")
    public ResponseEntity<Object> sortsalarybysalarydesc() {
        return new ResponseEntity<>(sortSalaryUseCase.sortBySalaryDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortsalarybysalaryasc")
    public ResponseEntity<Object> sortsalarybysalaryasc() {
        return new ResponseEntity<>(sortSalaryUseCase.sortBySalaryAsc(), HttpStatus.OK);
    }
}
