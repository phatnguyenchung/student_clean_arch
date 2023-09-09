package com.example.studentcleanarch.adapter.in.dto.request.salary;

import com.example.studentcleanarch.application.port.in.salary.UpdateSalaryCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UpdateSalaryRequest {
    private Long id;
    private Long teacherId;
    private int salary;
    private int bonus;
    private Date salaryDate;
    private Boolean salaryGiven;

    public UpdateSalaryCommand toCommand() {
        return UpdateSalaryCommand.builder()
                .id(id)
                .TeacherId(teacherId)
                .Salary(salary)
                .Bonus(bonus)
                .SalaryDate(salaryDate)
                .SalaryGiven(salaryGiven)
                .build();
    }
}
