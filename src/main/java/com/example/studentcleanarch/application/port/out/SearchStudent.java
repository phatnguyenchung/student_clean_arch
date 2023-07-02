package com.example.studentcleanarch.application.port.out;

import com.example.studentcleanarch.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchStudent {
    List<Student> searchStudentByName(String studentName);

    List<Student> searchStudentByPhoneNumber(Long phoneNumber);

    List<Student> searchStudentByIdNumber(String idNumber);
}
