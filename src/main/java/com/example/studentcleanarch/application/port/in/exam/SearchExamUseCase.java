package com.example.studentcleanarch.application.port.in.exam;

import com.example.studentcleanarch.domain.Exam;

import java.util.List;

public interface SearchExamUseCase {

    List<Exam> searchExamByStudentId(Long studentId);
}
