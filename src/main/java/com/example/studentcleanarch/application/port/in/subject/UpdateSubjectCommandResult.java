package com.example.studentcleanarch.application.port.in.subject;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateSubjectCommandResult {
    private boolean status;
}
