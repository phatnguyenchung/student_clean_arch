package com.example.studentcleanarch.application.port.out.exam;

import com.example.studentcleanarch.domain.Exam;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SearchExam {

    List<Exam> searchExamByStudentId(Long studentId);

    List<Exam> searchExamBySubjectId(Long subjectId);

    List<Exam> searchExamByScore(int score);

    List<Exam> searchExamByDate(Date examDate);
}
