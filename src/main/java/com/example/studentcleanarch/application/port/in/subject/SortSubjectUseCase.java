package com.example.studentcleanarch.application.port.in.subject;

import com.example.studentcleanarch.adapter.out.persistent.subject.SubjectJpaEntity;

import java.util.List;

public interface SortSubjectUseCase {
    List<SubjectJpaEntity> sortSubjectNameOrderByDesc();

    List<SubjectJpaEntity> sortSubjectNameOrderByAsc();
}
