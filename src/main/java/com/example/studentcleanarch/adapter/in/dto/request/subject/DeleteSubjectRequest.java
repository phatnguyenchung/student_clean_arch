package com.example.studentcleanarch.adapter.in.dto.request.subject;

import com.example.studentcleanarch.application.port.in.subject.DeleteSubjectCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class DeleteSubjectRequest {
    private Long id;
    private Long subjectId;
    private String subjectName;
    private Date startDate;
    private Date endDate;

    public DeleteSubjectCommand toCommand() {
        return DeleteSubjectCommand.builder()
                .id(id)
                .subjectId(subjectId)
                .subjectName(subjectName)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
