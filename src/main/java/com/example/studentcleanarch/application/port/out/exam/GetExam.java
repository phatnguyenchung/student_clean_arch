package com.example.studentcleanarch.application.port.out.exam;

import com.example.studentcleanarch.domain.Exam;

import java.util.List;

public interface GetExam {

    List<Exam> getAllEaxam();

    Exam getExamById(Long id);
}
