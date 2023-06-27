package com.example.studentcleanarch.application.port.out;

import com.example.studentcleanarch.domain.Student;
import org.springframework.stereotype.Component;

@Component
public interface UpdateStudent {
    void updateStudent(Student student);
}
