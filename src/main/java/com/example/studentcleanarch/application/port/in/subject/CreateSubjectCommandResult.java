package com.example.studentcleanarch.application.port.in.subject;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateSubjectCommandResult {
    private boolean status;
}
