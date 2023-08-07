package com.example.studentcleanarch.application.port.in.exam;

import com.example.studentcleanarch.domain.Exam;

import java.util.Date;
import java.util.List;

public interface SearchExamUseCase {

    List<Exam> searchExamByStudentId(Long studentId);

    List<Exam> searchExamBySubjectId(Long subjectId);

    List<Exam> searchExamByScore(int score);

    List<Exam> searchExamByDate(Date examDate);
}
