package com.example.studentcleanarch.adapter.in.dto.request.subject;

import com.example.studentcleanarch.application.port.in.subject.CreateSubjectCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CreateSubjectRequest {

    private Long subjectId;
    private String subjectName;
    private Long teacherId;
    private Date startDate;
    private Date endDate;

    public CreateSubjectCommand toCommand() {
        return CreateSubjectCommand.builder()
                .subjectId(subjectId)
                .subjectName(subjectName)
                .teacherId(teacherId)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
