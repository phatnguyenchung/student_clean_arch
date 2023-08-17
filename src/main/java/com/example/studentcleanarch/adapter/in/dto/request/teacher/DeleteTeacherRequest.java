package com.example.studentcleanarch.adapter.in.dto.request.teacher;

import com.example.studentcleanarch.application.port.in.teacher.DeleteTeacherCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteTeacherRequest {

    private Long id;

    public DeleteTeacherCommand toCommand() {
        return DeleteTeacherCommand.builder()
                .id(id)
                .build();
    }
}
