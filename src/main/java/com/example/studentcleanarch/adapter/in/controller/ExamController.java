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

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/exam", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExamController {
    private final CreateExamUseCase createExamUseCase;
    private final UpdateExamUseCase updateExamUseCase;
    private final DeleteExamUseCase deleteExamUseCase;
    private final SortExamUseCase sortExamUseCase;
    private final SearchExamUseCase searchExamUseCase;
    private final GetExamUseCase getExamUseCase;

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
        return ApiResponse.success(deleteExamUseCase.deleteExam(deleteExamRequest.toCommand()));
    }

    @GetMapping("/sortexambydateasc")
    public ResponseEntity<Object> sortexambydateasc() {
        return new ResponseEntity<>(sortExamUseCase.sortExamByDateAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortexambydatedesc")
    public ResponseEntity<Object> sortexambydatedesc() {
        return new ResponseEntity<>(sortExamUseCase.sortExamByDateDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortexambyscoreasc")
    public ResponseEntity<Object> sortexambyscoreasc() {
        return new ResponseEntity<>(sortExamUseCase.sortExamByScoreAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortexambyscoredesc")
    public ResponseEntity<Object> sortexambyscoredesc() {
        return new ResponseEntity<>(sortExamUseCase.sortExamByScoreDesc(), HttpStatus.OK);
    }

    @GetMapping("/searchexambystudentid")
    public ResponseEntity<Object> searchexambystudentid(@RequestParam Long studentId) {
        return new ResponseEntity<>(searchExamUseCase.searchExamByStudentId(studentId), HttpStatus.OK);
    }

    @GetMapping("/searchexambysubjectid")
    public ResponseEntity<Object> searchexambysubjectid(@RequestParam Long subjectId) {
        return new ResponseEntity<>(searchExamUseCase.searchExamBySubjectId(subjectId), HttpStatus.OK);
    }

    @GetMapping("/searchexambyscore")
    public ResponseEntity<Object> searchexambyscore(@RequestParam int score) {
        return new ResponseEntity<>(searchExamUseCase.searchExamByScore(score), HttpStatus.OK);
    }

    @GetMapping("/searchexambyexamdate")
    public ResponseEntity<Object> searchexambyexamdate(@RequestParam Date examDate) {
        return new ResponseEntity<>(searchExamUseCase.searchExamByDate(examDate), HttpStatus.OK);
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

    @GetMapping("/sortexambyidasc")
    public ResponseEntity<Object> sortexambyidasc() {
        return new ResponseEntity<>(sortExamUseCase.sortExamByIdAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortexambyiddesc")
    public ResponseEntity<Object> sortexambyiddesc() {
        return new ResponseEntity<>(sortExamUseCase.sortExamByIdDesc(), HttpStatus.OK);
    }

    @GetMapping("/getexambyid")
    public ResponseEntity<Object> getexambyid(@RequestParam Long id) {
        return new ResponseEntity<Object>(getExamUseCase.getExamById(id), HttpStatus.OK);
    }

    @GetMapping
    public ApiResponse<?> get() {
        return ApiResponse.success(getExamUseCase.getAllExam());
    }
}
