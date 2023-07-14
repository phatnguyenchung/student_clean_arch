package com.example.studentcleanarch.application.port.in.exam;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateExamCommandResult {
    private boolean status;
}
