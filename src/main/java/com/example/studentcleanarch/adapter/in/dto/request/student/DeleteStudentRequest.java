package com.example.studentcleanarch.adapter.in.dto.request.student;

import com.example.studentcleanarch.application.port.in.student.DeleteStudentCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteStudentRequest {
    private Long id;

    public DeleteStudentCommand toCommand() {
        return DeleteStudentCommand.builder()
                .id(id)
                .build();
    }
}
