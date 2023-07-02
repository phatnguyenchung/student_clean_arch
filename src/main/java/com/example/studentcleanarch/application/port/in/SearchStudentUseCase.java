package com.example.studentcleanarch.application.port.in;

import com.example.studentcleanarch.domain.Student;

import java.util.List;

public interface SearchStudentUseCase {

    List<Student> searchStudentByStudentName(String studentName);

    Student searchStudentByPhoneNumber(Long phoneNumber);
}
