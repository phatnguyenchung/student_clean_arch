package com.example.studentcleanarch.adapter.in.dto.request.salary;

import com.example.studentcleanarch.application.port.in.salary.CreateSalaryCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CreateSalaryRequest {
    private Long teacherId;
    private int salary;
    private Date salaryDate;
    private Boolean salaryGiven;

    public CreateSalaryCommand toCommand() {
        return CreateSalaryCommand.builder()
                .TeacherId(teacherId)
                .Salary(salary)
                .SalaryDate(salaryDate)
                .SalaryGiven(salaryGiven)
                .build();
    }
}
