package com.example.studentcleanarch.application.port.in.teacher;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DeleteTeacherCommandResult {
    private boolean status;
}
