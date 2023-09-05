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
        return new ResponseEntity<>(searchStudentUseCase.searchStudentByStudentLastName(studentLastName), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbyfirstname")
    public ResponseEntity<Object> searchstudentbyfirstname(@RequestParam String studentFirstName) {
        return new ResponseEntity<>(searchStudentUseCase.searchStudentByStudentFirstName(studentFirstName), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbyphonenumber")
    public ResponseEntity<Object> searchstudentphonenumber(@RequestParam Long phoneNumber) {
        return new ResponseEntity<>(searchStudentUseCase.searchStudentByPhoneNumber(phoneNumber), HttpStatus.OK);
    }

    @GetMapping("/getstudentbyid")
    public ResponseEntity<Object> getstudentbyid(@RequestParam Long id) {
        return new ResponseEntity<>(getStudentUseCase.getStudentById(id), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbycic")
    public ResponseEntity<Object> searchstudentbycic(@RequestParam String CIC) {
        return new ResponseEntity<>(searchStudentUseCase.searchStudentByCIC(CIC), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbyclassname")
    public ResponseEntity<Object> searchstudentbyclassname(@RequestParam String className) {
        return new ResponseEntity<>(searchStudentUseCase.searchStudentByClassName(className), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbyparentphonenumber")
    public ResponseEntity<Object> searchstudentbyparentphonenumber(@RequestParam Long parentPhoneNumber) {
        return new ResponseEntity<>(searchStudentUseCase.searchStudentByParentPhoneNumber(parentPhoneNumber), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbystudentparent")
    public ResponseEntity<Object> searchstudentbystudentparent(@RequestParam String studentParent) {
        return new ResponseEntity<>(searchStudentUseCase.searchStudentByStudentParent(studentParent), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbyjobtitle")
    public ResponseEntity<Object> searchstudentbyjobtitle(@RequestParam String jobTitle) {
        return new ResponseEntity<>(searchStudentUseCase.searchStudentByJobTitle(jobTitle), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbystudentid")
    public ResponseEntity<Object> searchstudentbystudentid(@RequestParam Long studentId) {
        return new ResponseEntity<>(searchStudentUseCase.searchStudentByStudentId(studentId), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbynationality")
    public ResponseEntity<Object> searchstudentbynationality(@RequestParam String nationality) {
        return new ResponseEntity<>(searchStudentUseCase.searchStudentByNationality(nationality), HttpStatus.OK);
    }

    @GetMapping("/searchstudentbyaddress")
    public ResponseEntity<Object> searchstudentbyaddress(@RequestParam String address) {
        return new ResponseEntity<>(searchStudentUseCase.searchStudentByAddress(address), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbylastnamedesc")
    public ResponseEntity<Object> sortstudentbynamedesc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentLastNameOrderByDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbylastnameasc")
    public ResponseEntity<Object> sortstudentbynameasc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentLastNameOrderByAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyiddesc")
    public ResponseEntity<Object> sortstudentbyiddesc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByIdDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyidasc")
    public ResponseEntity<Object> sortstudentbyidasc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByIdAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbycicdesc")
    public ResponseEntity<Object> sortstudentbycicdesc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByCICDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbycicasc")
    public ResponseEntity<Object> sortstudentbycicasc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByCICAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyclassnamedesc")
    public ResponseEntity<Object> sortstudentbyclassnamedesc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByClassNameDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyclassnameasc")
    public ResponseEntity<Object> sortstudentbyclassnameasc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByClassNameAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbystudentiddesc")
    public ResponseEntity<Object> sortstudentbystudentiddesc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByStudentIdDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbystudentidasc")
    public ResponseEntity<Object> sortstudentbystudentidasc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByStudentIdAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyadmissiondatedesc")
    public ResponseEntity<Object> sortstudentbyadmissiondatedesc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByAdmissionDateDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyadmissiondateasc")
    public ResponseEntity<Object> sortstudentbyadmissiondateasc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByAdmissionDateAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbycreateddatedesc")
    public ResponseEntity<Object> sortstudentbycreateddatedesc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByCreatedDateDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbycreateddateasc")
    public ResponseEntity<Object> sortstudentbycreateddateasc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByCreatedDateAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyjobtitledesc")
    public ResponseEntity<Object> sortstudentbyjobtitiledesc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByJobTitleDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyjobtitleasc")
    public ResponseEntity<Object> sortstudentbyjobtitileasc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByJobTitleAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyfirstnamedesc")
    public ResponseEntity<Object> sortstudentbyfirstnamedesc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByFirstNameDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbyfirstnameasc")
    public ResponseEntity<Object> sortstudentbyfirstnameasc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByFirstNameAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbynationalitydesc")
    public ResponseEntity<Object> sortstudentbynationalitydesc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByNationalityDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbynationalityasc")
    public ResponseEntity<Object> sortstudentbynationalityasc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByNationalityAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbybirthdatedesc")
    public ResponseEntity<Object> sortstudentbybirthdatedesc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByBirthDateDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortstudentbybirthdateasc")
    public ResponseEntity<Object> sortstudentbybirthdateasc() {
        return new ResponseEntity<>(sortStudentUseCase.sortStudentByBirthDateAsc(), HttpStatus.OK);
    }
}
