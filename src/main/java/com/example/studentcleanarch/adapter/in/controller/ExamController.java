package com.example.studentcleanarch.adapter.in.controller;

import com.example.studentcleanarch.adapter.in.dto.request.exam.CreateExamRequest;
import com.example.studentcleanarch.adapter.in.dto.request.exam.DeleteExamRequest;
import com.example.studentcleanarch.adapter.in.dto.request.exam.UpdateExamRequest;
import com.example.studentcleanarch.adapter.in.dto.response.ApiResponse;
import com.example.studentcleanarch.application.port.in.exam.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/exam", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExamController {
    private final CreateExamUseCase createExamUseCase;
    private final UpdateExamUseCase updateExamUseCase;
    private final DeleteExamUseCase deleteExamUseCase;
    private final SortExamUseCase sortExamUseCase;
    private final SearchExamUseCase searchExamUseCase;

    @PostMapping
    public ApiResponse<?> create(@RequestBody CreateExamRequest createExamRequest) {
        return ApiResponse.success(createExamUseCase.createExam(createExamRequest.toCommand()));
    }

    @PutMapping
    public ApiResponse<?> update(@RequestBody UpdateExamRequest updateExamRequest) {
        return ApiResponse.success(updateExamUseCase.updateExam(updateExamRequest.toCommand()));
    }

    @DeleteMapping
    public ApiResponse<?> delete(@RequestBody DeleteExamRequest deleteExamRequest) {
        return ApiResponse.success(deleteExamUseCase.deleteExam(deleteExamRequest.getId()));
    }

    @GetMapping("/sortexambydateasc")
    public ResponseEntity<Object> sortexambydateasc() {
        return new ResponseEntity<Object>(sortExamUseCase.sortExamByDateAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortexambydatedesc")
    public ResponseEntity<Object> sortexambydatedesc() {
        return new ResponseEntity<Object>(sortExamUseCase.sortExamByDateDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortexambyscoreasc")
    public ResponseEntity<Object> sortexambyscoreasc() {
        return new ResponseEntity<Object>(sortExamUseCase.sortExamByScoreAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortexambyscoredesc")
    public ResponseEntity<Object> sortexambyscoredesc() {
        return new ResponseEntity<Object>(sortExamUseCase.sortExamByScoreDesc(), HttpStatus.OK);
    }

    @GetMapping("/searchexambystudentid")
    public ResponseEntity<Object> searchexambystudentid(@RequestParam Long studentId) {
        return new ResponseEntity<Object>(searchExamUseCase.searchExamByStudentId(studentId), HttpStatus.OK);
    }

    @GetMapping("/searchexambysubjectid")
    public ResponseEntity<Object> searchexambysubjectid(@RequestParam Long subjectId) {
        return new ResponseEntity<Object>(searchExamUseCase.searchExamBySubjectId(subjectId), HttpStatus.OK);
    }

    @GetMapping("/sortexambystudentidasc")
    public ResponseEntity<Object> sortexambystudentidasc() {
        return new ResponseEntity<>(sortExamUseCase.sortExamByStudentIdAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortexambystudentiddesc")
    public ResponseEntity<Object> sortexambystudentiddesc() {
        return new ResponseEntity<>(sortExamUseCase.sortExamByStudentIdDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortexambysubjectidasc")
    public ResponseEntity<Object> sortexambysubjectidasc() {
        return new ResponseEntity<>(sortExamUseCase.sortExamBySubjectIdAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortexambysubjectiddesc")
    public ResponseEntity<Object> sortexambysubjectiddesc() {
        return new ResponseEntity<>(sortExamUseCase.sortExamBySubjectIdDesc(), HttpStatus.OK);
    }
}
