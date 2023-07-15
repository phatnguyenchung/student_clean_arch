package com.example.studentcleanarch.application.port.out.exam;

import com.example.studentcleanarch.domain.Exam;
import org.springframework.stereotype.Component;

@Component
public interface UpdateExam {
    void updateExam(Exam exam);
}
