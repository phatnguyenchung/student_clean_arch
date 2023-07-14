package com.example.studentcleanarch.adapter.in.dto.request.exam;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CreateExamRequest {
    private Long studentId;
    private Long subjectId;
    private Date examDate;
    private int score;
}
