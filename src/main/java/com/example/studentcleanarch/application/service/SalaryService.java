package com.example.studentcleanarch.application.service;

import com.example.studentcleanarch.application.port.in.salary.CreateSalaryCommand;
import com.example.studentcleanarch.application.port.in.salary.CreateSalaryCommandResult;
import com.example.studentcleanarch.application.port.in.salary.CreateSalaryUseCase;
import com.example.studentcleanarch.application.port.out.salary.CreateSalary;
import com.example.studentcleanarch.common.UseCase;
import com.example.studentcleanarch.domain.Salary;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
public class SalaryService implements CreateSalaryUseCase {
    private final CreateSalary createSalary;

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public CreateSalaryCommandResult createSalary(CreateSalaryCommand createSalaryCommand) {
        Salary salary = Salary.builder()
                .teacherId(createSalaryCommand.getTeacherId())
                .salary(createSalaryCommand.getSalary())
                .salaryDate(createSalaryCommand.getSalaryDate())
                .salaryGiven(createSalaryCommand.getSalaryGiven())
                .build();
        if (createSalaryCommand.getSalary() < 0)
            CreateSalaryCommandResult.builder().status(false).build();
        else
            createSalary.saveSalary(salary);
        return CreateSalaryCommandResult.builder().status(true).build();
    }
}
