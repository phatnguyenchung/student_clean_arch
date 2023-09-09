package com.example.studentcleanarch.application.port.in.salary;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Builder
public class CreateSalaryCommand {
    @NotBlank
    private Long TeacherId;
    private int Salary;
    private int Bonus;
    private Date SalaryDate;
    private Boolean SalaryGiven;
}
