package com.example.studentcleanarch.application.port.in.exam;

import com.example.studentcleanarch.domain.Exam;

import java.util.List;

public interface GetExamUseCase {
    List<Exam> getAllExam();

    Exam getExamById(Long id);
}
