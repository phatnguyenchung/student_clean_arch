package com.example.studentcleanarch.application.port.in;

import com.example.studentcleanarch.domain.Student;

public interface SearchStudentUseCase {

    Student searchStudentByStudentName(String studentName);

    Student searchStudentByPhoneNumber(Long phoneNumber);
}
