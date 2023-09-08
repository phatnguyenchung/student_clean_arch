package com.example.studentcleanarch.application.port.in.salary;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class DeleteSalaryCommand {
    private Long id;
}
