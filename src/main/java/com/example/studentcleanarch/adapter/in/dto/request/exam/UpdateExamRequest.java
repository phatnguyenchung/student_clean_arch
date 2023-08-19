package com.example.studentcleanarch.adapter.in.dto.request.exam;

import com.example.studentcleanarch.application.port.in.exam.UpdateExamCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UpdateExamRequest {

    private Long id;
    private Long studentId;
    private Long subjectId;
    private Long teacherId;
    private Date examDate;
    private int score;

    public UpdateExamCommand toCommand() {
        return UpdateExamCommand.builder()
                .id(id)
                .StudentId(studentId)
                .SubjectId(subjectId)
                .TeacherId(teacherId)
                .ExamDate(examDate)
                .Score(score)
                .build();
    }
}
