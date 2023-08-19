package com.example.studentcleanarch.adapter.out.persistent.exam;

import com.example.studentcleanarch.domain.Exam;

public class ExamMapper {

    public static ExamJpaEntity mapToJpaEntity(Exam exam) {
        return ExamJpaEntity.builder()
                .id(exam.getId())
                .studentId(exam.getStudentId())
                .subjectId(exam.getSubjectId())
                .teacherId(exam.getTeacherId())
                .examDate(exam.getExamDate())
                .score(exam.getScore())
                .build();
    }

    public static Exam mapToDomainEntity(ExamJpaEntity entity) {
        return Exam.builder()
                .id(entity.getId())
                .studentId(entity.getStudentId())
                .subjectId(entity.getSubjectId())
                .teacherId(entity.getTeacherId())
                .examDate(entity.getExamDate())
                .score(entity.getScore())
                .build();
    }

    public static ExamJpaEntity mapToExistedJpaEntity(Exam exam, ExamJpaEntity entity) {
        entity.setId(exam.getId());
        entity.setStudentId(exam.getStudentId());
        entity.setSubjectId(exam.getSubjectId());
        entity.setTeacherId(exam.getTeacherId());
        entity.setExamDate(exam.getExamDate());
        entity.setScore(exam.getScore());
        return entity;
    }
}
