package com.example.studentcleanarch.application.port.in;

import com.example.studentcleanarch.domain.Student;

import java.util.List;

public interface GetStudentUseCase {
    List<Student> getAllStudent();

    Student getStudentById(Long id);
}
