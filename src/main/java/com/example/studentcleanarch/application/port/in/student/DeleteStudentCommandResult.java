package com.example.studentcleanarch.application.port.in.student;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DeleteStudentCommandResult {
    private boolean status;
}
