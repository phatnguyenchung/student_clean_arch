package com.example.studentcleanarch.adapter.in.controller;

import com.example.studentcleanarch.adapter.in.dto.request.teacher.CreateTeacherRequest;
import com.example.studentcleanarch.adapter.in.dto.request.teacher.DeleteTeacherRequest;
import com.example.studentcleanarch.adapter.in.dto.request.teacher.UpdateTeacherRequest;
import com.example.studentcleanarch.adapter.in.dto.response.ApiResponse;
import com.example.studentcleanarch.application.port.in.teacher.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/teacher", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeacherController {

    private final CreateTeacherUseCase createTeacherUseCase;
    private final UpdateTeacherUseCase updateTeacherUseCase;
    private final DeleteTeacherUseCase deleteTeacherUseCase;
    private final GetTeacherUseCase getTeacherUseCase;
    private final SearchTeacherUseCase searchTeacherUseCase;
    private final SortTeacherUseCase sortTeacherUseCase;

    @PostMapping
    public ApiResponse<?> create(@RequestBody CreateTeacherRequest createTeacherRequest) {
        return ApiResponse.success(createTeacherUseCase.createTeacher(createTeacherRequest.toCommand()));
    }

    @PutMapping
    public ApiResponse<?> update(@RequestBody UpdateTeacherRequest updateTeacherRequest) {
        return ApiResponse.success(updateTeacherUseCase.updateTeacher(updateTeacherRequest.toCommand()));
    }

    @DeleteMapping
    public ApiResponse<?> delete(@RequestBody DeleteTeacherRequest deleteTeacherRequest) {
        return ApiResponse.success(deleteTeacherUseCase.deleteTeacher(deleteTeacherRequest.toCommand()));
    }

    @GetMapping
    public ApiResponse<?> get() {
        return ApiResponse.success(getTeacherUseCase.getAllTeacher());
    }

    @GetMapping("/getteacherbyid")
    public ResponseEntity<Object> getteacherbyid(@RequestParam Long id) {
        return new ResponseEntity<>(getTeacherUseCase.getTeacherById(id), HttpStatus.OK);
    }

    @GetMapping("/searchteacherbylastname")
    public ResponseEntity<Object> searchteacherbylastname(@RequestParam String teacherLastName) {
        return new ResponseEntity<>(searchTeacherUseCase.searchTeacherByLastName(teacherLastName), HttpStatus.OK);
    }

    @GetMapping("/searchteacherbycic")
    public ResponseEntity<Object> searchteacherbycic(@RequestParam String CIC) {
        return new ResponseEntity<>(searchTeacherUseCase.searchTeacherByCIC(CIC), HttpStatus.OK);
    }

    @GetMapping("/searchteacherbyaddress")
    public ResponseEntity<Object> searchteacherbyaddress(@RequestParam String address) {
        return new ResponseEntity<>(searchTeacherUseCase.searchTeacherByAddress(address), HttpStatus.OK);
    }

    @GetMapping("/searchteacherbyphonenumber")
    public ResponseEntity<Object> searchteacherbyphonenumber(@RequestParam String phoneNumber) {
        return new ResponseEntity<>(searchTeacherUseCase.searchTeacherByPhoneNumber(phoneNumber), HttpStatus.OK);
    }

    @GetMapping("/sortiddesc")
    public ResponseEntity<Object> sortiddesc() {
        return new ResponseEntity<>(sortTeacherUseCase.sortTeacherByIdDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortidasc")
    public ResponseEntity<Object> sortidasc() {
        return new ResponseEntity<>(sortTeacherUseCase.sortTeacherByIdAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortteacheriddesc")
    public ResponseEntity<Object> sortteacheriddesc() {
        return new ResponseEntity<>(sortTeacherUseCase.sortTeacherByTeacherIdDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortteacheridasc")
    public ResponseEntity<Object> sortteacheridasc() {
        return new ResponseEntity<>(sortTeacherUseCase.sortTeacherByTeacherIdAsc(), HttpStatus.OK);
    }

    @GetMapping("/sortteacherlastnamedesc")
    public ResponseEntity<Object> sortteacherlastnamedesc() {
        return new ResponseEntity<>(sortTeacherUseCase.sortTeacherByTeacherLastNameDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortteacherlastnameasc")
    public ResponseEntity<Object> sortteacherlastnameasc() {
        return new ResponseEntity<>(sortTeacherUseCase.sortTeacherByTeacherLastNameAsc(), HttpStatus.OK);
    }


    @GetMapping("/sortteacherfirstnamedesc")
    public ResponseEntity<Object> sortteacherfirstnamedesc() {
        return new ResponseEntity<>(sortTeacherUseCase.sortTeacherByTeacherFirstNameDesc(), HttpStatus.OK);
    }

    @GetMapping("/sortteacherfirstnameasc")
    public ResponseEntity<Object> sortteacherfirstnameasc() {
        return new ResponseEntity<>(sortTeacherUseCase.sortTeacherByTeacherFirstNameAsc(), HttpStatus.OK);
    }
}
