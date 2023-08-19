package com.example.studentcleanarch.adapter.in.dto.request.exam;

import com.example.studentcleanarch.application.port.in.exam.CreateExamCommand;
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
    private Long teacherId;
    private Date examDate;
    private int score;

    public CreateExamCommand toCommand() {
        return CreateExamCommand.builder()
                .StudentId(studentId)
                .SubjectId(subjectId)
                .TeacherId(teacherId)
                .ExamDate(examDate)
                .Score(score)
                .build();
    }
}
