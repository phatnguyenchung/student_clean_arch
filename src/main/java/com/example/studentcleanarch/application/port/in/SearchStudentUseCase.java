package com.example.studentcleanarch.application.port.in;

import com.example.studentcleanarch.domain.Student;

import java.util.List;

public interface SearchStudentUseCase {

    List<Student> searchStudentByStudentLastName(String studentLastName);

    List<Student> searchStudentByPhoneNumber(Long phoneNumber);

    List<Student> searchStudentByIdNumber(String idNumber);
}
