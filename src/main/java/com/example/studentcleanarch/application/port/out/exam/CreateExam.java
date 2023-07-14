package com.example.studentcleanarch.application.port.out.exam;

import com.example.studentcleanarch.domain.Exam;

public interface CreateExam {
    Exam saveExam(Exam exam);
}
