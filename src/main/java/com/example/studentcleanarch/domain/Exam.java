package com.example.studentcleanarch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class Exam {
    private Long id;
    private Long studentId;
    private Long subjectId;
    private Long teacherId;
    private Date examDate;
    private int score;
}
