package com.example.studentcleanarch.application.port.in.salary;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DeleteSalaryCommandResult {
    private boolean status;
}
