package com.example.studentcleanarch.application.port.in.exam;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Builder
public class UpdateExamCommand {
    @NotBlank
    private Long id;
    @NotBlank
    private Long StudentId;
    @NotBlank
    private Long SubjectId;
    @NotBlank
    private Long TeacherId;
    private Date ExamDate;
    private Integer Score;
}
