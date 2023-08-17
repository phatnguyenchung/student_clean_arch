package com.example.studentcleanarch.adapter.in.controller;

import com.example.studentcleanarch.adapter.in.dto.request.subject.CreateSubjectRequest;
import com.example.studentcleanarch.adapter.in.dto.request.subject.DeleteSubjectRequest;
import com.example.studentcleanarch.adapter.in.dto.request.subject.UpdateSubjectRequest;
import com.example.studentcleanarch.adapter.in.dto.response.ApiResponse;
import com.example.studentcleanarch.application.port.in.subject.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/subject", produces = MediaType.APPLICATION_JSON_VALUE)
public class SubjectController {

    private final CreateSubjectUseCase createSubjectUseCase;
    private final UpdateSubjectUseCase updateSubjectUseCase;
    private final DeleteSubjectUseCase deleteSubjectUseCase;
    private final GetSubjectUseCase getSubjectUseCase;
    private final SearchSubjectUseCase searchSubjectUseCase;
    private final SortSubjectUseCase sortSubjectUseCase;

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
        return ApiResponse.success(deleteSubjectUseCase.deleteSubject(deleteSubjectRequest.toCommand()));
    }

    @GetMapping
    public ApiResponse<?> get() {
        return ApiResponse.success(getSubjectUseCase.getAllSubject());
    }

    @GetMapping("/getsubjectbyid")
    public ResponseEntity<Object> getsubjectbyid(@RequestParam Long id) {
        return new ResponseEntity<>(getSubjectUseCase.getSubjectById(id), HttpStatus.OK);
    }

    @GetMapping("/searchbysubjectname")
    public ResponseEntity<Object> searchbysubjectname(@RequestParam String subjectName) {
        return new ResponseEntity<>(searchSubjectUseCase.searchSubject(subjectName), HttpStatus.OK);
    }

    @GetMapping("/searchsubjectbystartdate")
    public ResponseEntity<Object> searchsubjectbystartdate(@RequestParam Date startDate) {
        return new ResponseEntity<>(searchSubjectUseCase.searchSubjectByStartDate(startDate), HttpStatus.OK);
    }

    @GetMapping("/sortsubjectnamedesc")
    public ResponseEntity<Object> sortsubjectnamedesc() {
        return new ResponseEntity<>(sortSubjectUseCase.sortSubjectNameOrderByDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortsubjectnameasc")
    public ResponseEntity<Object> sortsubjectnameasc() {
        return new ResponseEntity<>(sortSubjectUseCase.sortSubjectNameOrderByAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortiddesc")
    public ResponseEntity<Object> sortiddesc() {
        return new ResponseEntity<>(sortSubjectUseCase.sortIdByDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortidasc")
    public ResponseEntity<Object> sortidasc() {
        return new ResponseEntity<>(sortSubjectUseCase.sortIdByAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstartdatedesc")
    public ResponseEntity<Object> sortstartdatedesc() {
        return new ResponseEntity<>(sortSubjectUseCase.sortStartDateDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstartdateasc")
    public ResponseEntity<Object> sortstartdateasc() {
        return new ResponseEntity<>(sortSubjectUseCase.sortStartDateAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortenddatedesc")
    public ResponseEntity<Object> sortenddatedesc() {
        return new ResponseEntity<>(sortSubjectUseCase.sortEndDateDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortenddateasc")
    public ResponseEntity<Object> sortenddateasc() {
        return new ResponseEntity<>(sortSubjectUseCase.sortEndDateAsc(), HttpStatus.OK);
    }
}
