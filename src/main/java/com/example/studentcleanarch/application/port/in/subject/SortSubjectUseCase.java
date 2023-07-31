package com.example.studentcleanarch.application.port.in.subject;

import com.example.studentcleanarch.adapter.out.persistent.subject.SubjectJpaEntity;

import java.util.List;

public interface SortSubjectUseCase {
    List<SubjectJpaEntity> sortSubjectNameOrderByDesc();

    List<SubjectJpaEntity> sortSubjectNameOrderByAsc();

    List<SubjectJpaEntity> sortIdByDesc();

    List<SubjectJpaEntity> sortIdByAsc();

    List<SubjectJpaEntity> sortStartDateDesc();

    List<SubjectJpaEntity> sortStartDateAsc();

    List<SubjectJpaEntity> sortEndDateDesc();

    List<SubjectJpaEntity> sortEndDateAsc();
}
