package com.example.studentcleanarch.application.port.in.exam;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class DeleteExamCommand {
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
