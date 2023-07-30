package com.example.studentcleanarch.application.port.out.exam;

import com.example.studentcleanarch.adapter.out.persistent.exam.ExamJpaEntity;

import java.util.List;

public interface SortExam {
    List<ExamJpaEntity> sortExamByDateDesc();

    List<ExamJpaEntity> sortExamByDateAsc();

    List<ExamJpaEntity> sortExamByScoreDesc();

    List<ExamJpaEntity> sortExamByScoreAsc();

    List<ExamJpaEntity> sortExamByStudentIdDesc();

    List<ExamJpaEntity> sortExamByStudentIdAsc();

    List<ExamJpaEntity> sortExamBySubjectIdDesc();

    List<ExamJpaEntity> sortExamBySubjectIdAsc();

    List<ExamJpaEntity> sortExamByIdAsc();

    List<ExamJpaEntity> sortExamByIdDesc();
}
