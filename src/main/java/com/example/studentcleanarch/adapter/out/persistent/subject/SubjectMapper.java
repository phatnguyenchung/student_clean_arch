package com.example.studentcleanarch.adapter.out.persistent.subject;

import com.example.studentcleanarch.domain.Subject;

public class SubjectMapper {

    public static SubjectJpaEntity mapToJpaEntity(Subject subject) {
        return SubjectJpaEntity.builder()
                .id(subject.getId())
                .subjectId(subject.getSubjectId())
                .subjectName(subject.getSubjectName())
                .startDate(subject.getStartDate())
                .endDate(subject.getEndDate())
                .build();
    }

    public static Subject mapToDomainEntity(SubjectJpaEntity entity) {
        return Subject.builder()
                .id(entity.getId())
                .subjectId(entity.getSubjectId())
                .subjectName(entity.getSubjectName())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .build();
    }

    public static SubjectJpaEntity mapToExistedJpaEntity(Subject subject, SubjectJpaEntity entity) {
        entity.setId(subject.getId());
        entity.setSubjectId(subject.getSubjectId());
        entity.setSubjectName(subject.getSubjectName());
        entity.setStartDate(subject.getStartDate());
        entity.setEndDate(subject.getEndDate());
        return entity;
    }
}
