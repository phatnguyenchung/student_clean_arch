package com.example.studentcleanarch.adapter.out.persistent.tuitionfee;

import com.example.studentcleanarch.domain.TuitionFee;

public class TuitionFeeMapper {

    public static TuitionFeeJpaEntity mapToJpaEntity(TuitionFee tuitionFee) {
        return TuitionFeeJpaEntity.builder()
                .id(tuitionFee.getId())
                .studentId(tuitionFee.getStudentId())
                .teacherId(tuitionFee.getTeacherId())
                .subjectId(tuitionFee.getSubjectId())
                .fee(tuitionFee.getFee())
                .feeDate(tuitionFee.getFeeDate())
                .build();
    }

    public static TuitionFee mapToDomainEntity(TuitionFeeJpaEntity entity) {
        return TuitionFee.builder()
                .id(entity.getId())
                .studentId(entity.getStudentId())
                .teacherId(entity.getTeacherId())
                .subjectId(entity.getSubjectId())
                .fee(entity.getFee())
                .feeDate(entity.getFeeDate())
                .build();
    }

    public static TuitionFeeJpaEntity mapToExistedJpaEntity(TuitionFee tuitionFee, TuitionFeeJpaEntity entity) {
        entity.setId(tuitionFee.getId());
        entity.setStudentId(tuitionFee.getStudentId());
        entity.setTeacherId(tuitionFee.getTeacherId());
        entity.setSubjectId(tuitionFee.getSubjectId());
        entity.setFee(tuitionFee.getFee());
        entity.setFeeDate(tuitionFee.getFeeDate());
        return entity;
    }
}
