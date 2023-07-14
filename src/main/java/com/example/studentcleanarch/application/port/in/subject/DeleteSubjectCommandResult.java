package com.example.studentcleanarch.application.port.in.subject;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DeleteSubjectCommandResult {
    private boolean status;
}
