package com.example.studentcleanarch.application.port.out;

import com.example.studentcleanarch.domain.Student;

public interface CreateStudent {
    Student saveStudent(Student student);
}
