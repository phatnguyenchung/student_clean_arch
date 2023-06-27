package com.example.studentcleanarch.application.port.out;

import com.example.studentcleanarch.domain.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchStudent {
    Student searchStudentByName(String studentName);
}
