package com.example.studentcleanarch.adapter.in.controller;

import com.example.studentcleanarch.adapter.in.dto.request.student.CreateStudentRequest;
import com.example.studentcleanarch.adapter.in.dto.request.student.DeleteStudentRequest;
import com.example.studentcleanarch.adapter.in.dto.request.student.UpdateStudentRequest;
import com.example.studentcleanarch.adapter.in.dto.response.ApiResponse;
import com.example.studentcleanarch.application.port.in.student.*;
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
        return ApiResponse.success(deleteStudentUseCase.deleteStudent(deleteStudentRequest.toCommand()));
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

    @GetMapping("/searchstudentbycic")
    public ResponseEntity<Object> searchstudentbycic(@RequestParam String CIC) {
        return new ResponseEntity<Object>(searchStudentUseCase.searchStudentByCIC(CIC), HttpStatus.OK);
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

    @GetMapping("/searchstudentbyjobtitle")
    public ResponseEntity<Object> searchstudentbyjobtitle(@RequestParam String jobTitle) {
        return new ResponseEntity<Object>(searchStudentUseCase.searchStudentByJobTitle(jobTitle), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbystudentid")
    public ResponseEntity<Object> searchstudentbystudentid(@RequestParam Long studentId) {
        return new ResponseEntity<Object>(searchStudentUseCase.searchStudentByStudentId(studentId), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbynationality")
    public ResponseEntity<Object> searchstudentbynationality(@RequestParam String nationality) {
        return new ResponseEntity<Object>(searchStudentUseCase.searchStudentByNationality(nationality), HttpStatus.OK);
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

    @GetMapping("/sortstudentbycicdesc")
    public ResponseEntity<Object> sortstudentbycicdesc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByCICDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbycicasc")
    public ResponseEntity<Object> sortstudentbycicasc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByCICAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyclassnamedesc")
    public ResponseEntity<Object> sortstudentbyclassnamedesc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByClassNameDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyclassnameasc")
    public ResponseEntity<Object> sortstudentbyclassnameasc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByClassNameAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbystudentiddesc")
    public ResponseEntity<Object> sortstudentbystudentiddesc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByStudentIdDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbystudentidasc")
    public ResponseEntity<Object> sortstudentbystudentidasc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByStudentIdAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyadmissiondatedesc")
    public ResponseEntity<Object> sortstudentbyadmissiondatedesc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByAdmissionDateDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyadmissiondateasc")
    public ResponseEntity<Object> sortstudentbyadmissiondateasc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByAdmissionDateAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbycreateddatedesc")
    public ResponseEntity<Object> sortstudentbycreateddatedesc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByCreatedDateDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbycreateddateasc")
    public ResponseEntity<Object> sortstudentbycreateddateasc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByCreatedDateAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyjobtitledesc")
    public ResponseEntity<Object> sortstudentbyjobtitiledesc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByJobTitleDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyjobtitleasc")
    public ResponseEntity<Object> sortstudentbyjobtitileasc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByJobTitleAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyfirstnamedesc")
    public ResponseEntity<Object> sortstudentbyfirstnamedesc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByFirstNameDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyfirstnameasc")
    public ResponseEntity<Object> sortstudentbyfirstnameasc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByFirstNameAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbynationalitydesc")
    public ResponseEntity<Object> sortstudentbynationalitydesc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByNationalityDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbynationalityasc")
    public ResponseEntity<Object> sortstudentbynationalityasc() {
        return new ResponseEntity<Object>(sortStudentUseCase.sortStudentByNationalityAsc(), HttpStatus.OK);
    }
}
