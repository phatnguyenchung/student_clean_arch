package com.example.studentcleanarch.adapter.out.persistent.subject;

import com.example.studentcleanarch.domain.Subject;

public class SubjectMapper {

    public static SubjectJpaEntity mapToJpaEntity(Subject subject) {
        return SubjectJpaEntity.builder()
                .id(subject.getId())
                .subjectId(subject.getSubjectId())
                .subjectName(subject.getSubjectName())
                .teacherId(subject.getTeacherId())
                .startDate(subject.getStartDate())
                .endDate(subject.getEndDate())
                .active(subject.getActive())
                .build();
    }

    public static Subject mapToDomainEntity(SubjectJpaEntity entity) {
        return Subject.builder()
                .id(entity.getId())
                .subjectId(entity.getSubjectId())
                .subjectName(entity.getSubjectName())
                .teacherId(entity.getTeacherId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .active(entity.isActive())
                .build();
    }

    public static SubjectJpaEntity mapToExistedJpaEntity(Subject subject, SubjectJpaEntity entity) {
        entity.setId(subject.getId());
        entity.setSubjectId(subject.getSubjectId());
        entity.setSubjectName(subject.getSubjectName());
        entity.setTeacherId(subject.getTeacherId());
        entity.setStartDate(subject.getStartDate());
        entity.setEndDate(subject.getEndDate());
        entity.setActive(subject.getActive());
        return entity;
    }
}
