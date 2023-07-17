package com.example.studentcleanarch.application.port.in.exam;

import com.example.studentcleanarch.adapter.out.persistent.exam.ExamJpaEntity;

import java.util.List;

public interface SortExamUseCase {

    List<ExamJpaEntity> sortExamByDateDesc();

    List<ExamJpaEntity> sortExamByDateAsc();

    List<ExamJpaEntity> sortExamByScoreDesc();

    List<ExamJpaEntity> sortExamByScoreAsc();
}
