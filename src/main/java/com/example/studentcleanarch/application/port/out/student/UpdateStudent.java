package com.example.studentcleanarch.application.port.out.student;

import com.example.studentcleanarch.domain.Student;
import org.springframework.stereotype.Component;

@Component
public interface UpdateStudent {
    void updateStudent(Student student);
}
