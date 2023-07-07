package com.example.studentcleanarch.adapter.in.controller;

import com.example.studentcleanarch.adapter.in.dto.request.CreateStudentRequest;
import com.example.studentcleanarch.adapter.in.dto.request.DeleteStudentRequest;
import com.example.studentcleanarch.adapter.in.dto.request.UpdateStudentRequest;
import com.example.studentcleanarch.adapter.in.dto.response.ApiResponse;
import com.example.studentcleanarch.application.port.in.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    private final CreateStudentUseCase createStudentUseCase;
    private final UpdateStudentUseCase updateStudentUseCase;
    private final GetStudentUseCase getStudentUseCase;
    private final DeleteStudentUseCase deleteStudentUseCase;
    private final SearchStudentUseCase searchStudentUseCase;
    private final SortStudentUseCase sortStudentUseCase;

    @PostMapping
    public ApiResponse<?> create(@RequestBody CreateStudentRequest createStudentRequest) {
        return ApiResponse.success(createStudentUseCase.createStudent(createStudentRequest.toCommand()));
    }

    @PutMapping
    public ApiResponse<?> update(@RequestBody UpdateStudentRequest updateStudentRequest) {
        return ApiResponse.success(updateStudentUseCase.updateStudent(updateStudentRequest.toCommand()));
    }

    @GetMapping
    public ApiResponse<?> get() {
        return ApiResponse.success(getStudentUseCase.getAllStudent());
    }

    @DeleteMapping
    public ApiResponse<?> delete(@RequestBody DeleteStudentRequest deleteStudentRequest) {
        return ApiResponse.success(deleteStudentUseCase.deleteStudent(deleteStudentRequest.getId()));
    }

    @GetMapping("/searchstudentbylastname")
    public ResponseEntity<Object> searchstudentbylastname(@RequestParam String studentLastName) {
        return new ResponseEntity<Object>(searchStudentUseCase.searchStudentByStudentLastName(studentLastName), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbyphonenumber")
    public ResponseEntity<Object> searchstudentphonenumber(@RequestParam Long phoneNumber) {
        return new ResponseEntity<Object>(searchStudentUseCase.searchStudentByPhoneNumber(phoneNumber), HttpStatus.OK);
    }

    @GetMapping("/getstudentbyid")
    public ResponseEntity<Object> getstudentbyid(@RequestParam Long id) {
        return new ResponseEntity<Object>(getStudentUseCase.getStudentById(id), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbyidnumber")
    public ResponseEntity<Object> searchstudentbyidnumber(@RequestParam String idNumber) {
        return new ResponseEntity<Object>(searchStudentUseCase.searchStudentByIdNumber(idNumber), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbyclassname")
    public ResponseEntity<Object> searchstudentbyclassname(@RequestParam String className) {
        return new ResponseEntity<Object>(searchStudentUseCase.searchStudentByClassName(className), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbyparentphonenumber")
    public ResponseEntity<Object> searchstudentbyparentphonenumber(@RequestParam Long parentPhoneNumber) {
        return new ResponseEntity<Object>(searchStudentUseCase.searchStudentByParentPhoneNumber(parentPhoneNumber), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbystudentparent")
    public ResponseEntity<Object> searchstudentbystudentparent(@RequestParam String studentParent) {
        return new ResponseEntity<Object>(searchStudentUseCase.searchStudentByStudentParent(studentParent), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbylastnamedesc")
    public ResponseEntity<Object> sortstudentbynamedesc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentLastNameOrderByDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbylastnameasc")
    public ResponseEntity<Object> sortstudentbynameasc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentLastNameOrderByAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyiddesc")
    public ResponseEntity<Object> sortstudentbyiddesc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByIdDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyidasc")
    public ResponseEntity<Object> sortstudentbyidasc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByIdAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyidnumberdesc")
    public ResponseEntity<Object> sortstudentbyidnumberdesc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByIdNumberDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyidnumberasc")
    public ResponseEntity<Object> sortstudentbyidnumberasc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByIdNumberAsc(), HttpStatus.OK);
    }
}
