package com.example.studentcleanarch.application.port.in.teacher;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateTeacherCommandResult {
    private boolean status;
}
