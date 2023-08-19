package com.example.studentcleanarch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class Subject {
    private Long id;
    private Long subjectId;
    private String subjectName;
    private Long teacherId;
    private Date startDate;
    private Date endDate;
}
