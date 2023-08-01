package com.example.studentcleanarch.application.port.in.subject;

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
public class DeleteSubjectCommand {
    private Long id;
    @NotBlank
    private Long subjectId;
    private String subjectName;
    private Date startDate;
    private Date endDate;
}
