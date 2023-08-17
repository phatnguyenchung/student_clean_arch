package com.example.studentcleanarch.application.port.in.teacher;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateTeacherCommandResult {
    private boolean status;
}
