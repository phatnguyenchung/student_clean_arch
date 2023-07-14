package com.example.studentcleanarch.application.port.in.student;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateStudentCommandResult {
    private boolean status;
}
