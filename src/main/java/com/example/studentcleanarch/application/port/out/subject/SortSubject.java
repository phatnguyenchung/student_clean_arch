package com.example.studentcleanarch.application.port.out.subject;

import com.example.studentcleanarch.adapter.out.persistent.subject.SubjectJpaEntity;

import java.util.List;

public interface SortSubject {
    List<SubjectJpaEntity> sortSubjectNameDesc();

    List<SubjectJpaEntity> sortSubjectNameAsc();

    List<SubjectJpaEntity> sortIdDesc();

    List<SubjectJpaEntity> sortIdAsc();

    List<SubjectJpaEntity> sortStartDateDesc();

    List<SubjectJpaEntity> sortStartDateAsc();
}
