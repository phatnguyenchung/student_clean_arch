package com.example.studentcleanarch.application.port.out.student;

import com.example.studentcleanarch.domain.Student;

public interface CreateStudent {
    Student saveStudent(Student student);
}
