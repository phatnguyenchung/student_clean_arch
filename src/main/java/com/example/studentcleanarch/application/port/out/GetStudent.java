package com.example.studentcleanarch.application.port.out;

import com.example.studentcleanarch.adapter.out.persistent.student.StudentJpaEntity;
import com.example.studentcleanarch.domain.Student;

import java.util.List;
import java.util.Optional;

public interface GetStudent {
    List<Student> getAllStudent();

    Student getStudentById(long id);
}
