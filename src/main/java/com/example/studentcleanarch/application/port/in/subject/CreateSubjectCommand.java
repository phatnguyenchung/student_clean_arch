package com.example.studentcleanarch.application.port.in.subject;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Builder
public class CreateSubjectCommand {
    @NotBlank
    private Long subjectId;
    private String subjectName;
    private Long teacherId;
    private Date startDate;
    private Date endDate;
    private Boolean active;
}
