package com.example.studentcleanarch.application.port.in.exam;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DeleteExamCommandResult {
    private boolean status;
}
