package com.example.studentcleanarch.application.port.in;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateStudentCommandResult {
    private boolean status;
}
