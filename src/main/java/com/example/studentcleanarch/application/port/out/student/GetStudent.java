package com.example.studentcleanarch.application.port.out.student;

import com.example.studentcleanarch.domain.Student;

import java.util.List;

public interface GetStudent {
    List<Student> getAllStudent();

    Student getStudentById(Long id);
}
