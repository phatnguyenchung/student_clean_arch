package com.example.studentcleanarch.adapter.in.dto.request.subject;

import com.example.studentcleanarch.application.port.in.subject.DeleteSubjectCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteSubjectRequest {
    private Long id;

    public DeleteSubjectCommand toCommand() {
        return DeleteSubjectCommand.builder()
                .id(id)
                .build();
    }
}
