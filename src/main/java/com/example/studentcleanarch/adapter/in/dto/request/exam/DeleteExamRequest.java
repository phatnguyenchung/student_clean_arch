package com.example.studentcleanarch.adapter.in.dto.request.exam;

import com.example.studentcleanarch.application.port.in.exam.DeleteExamCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteExamRequest {
    private Long id;

    public DeleteExamCommand toCommand() {
        return DeleteExamCommand.builder()
                .id(id)
                .build();
    }
}
