package com.example.studentcleanarch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class TuitionFee {
    private Long id;
    private Long studentId;
    private Long teacherId;
    private Long subjectId;
    private int fee;
    private Date feeDate;
}
