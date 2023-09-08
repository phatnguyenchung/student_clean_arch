package com.example.studentcleanarch.application.port.in.salary;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateSalaryCommandResult {
    private boolean status;
}
