package com.example.studentcleanarch.application.service;

import com.example.studentcleanarch.application.port.in.salary.*;
import com.example.studentcleanarch.application.port.out.salary.CreateSalary;
import com.example.studentcleanarch.application.port.out.salary.DeleteSalary;
import com.example.studentcleanarch.application.port.out.salary.UpdateSalary;
import com.example.studentcleanarch.common.UseCase;
import com.example.studentcleanarch.domain.Salary;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
public class SalaryService implements CreateSalaryUseCase, UpdateSalaryUseCase, DeleteSalaryUseCase {
    private final CreateSalary createSalary;
    private final UpdateSalary updateSalary;
    private final DeleteSalary deleteSalary;

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
        else if (createSalaryCommand.getTeacherId() == null)
            CreateSalaryCommandResult.builder().status(false).build();
        else
            createSalary.saveSalary(salary);
        return CreateSalaryCommandResult.builder().status(true).build();
    }

    @Override
    public UpdateSalaryCommandResult updateSalary(UpdateSalaryCommand updateSalaryCommand) {
        Salary salary = Salary.builder()
                .id(updateSalaryCommand.getId())
                .teacherId(updateSalaryCommand.getTeacherId())
                .salary(updateSalaryCommand.getSalary())
                .salaryGiven(updateSalaryCommand.getSalaryGiven())
                .build();
        if (updateSalaryCommand.getSalary() < 0)
            UpdateSalaryCommandResult.builder().status(false).build();
        else if (updateSalaryCommand.getTeacherId() == null && updateSalaryCommand.getId() == null) {
            UpdateSalaryCommandResult.builder().status(false).build();
        } else
            updateSalary.updateSalary(salary);
        return UpdateSalaryCommandResult.builder().status(true).build();
    }

    @Override
    public DeleteSalaryCommandResult deleteSalary(DeleteSalaryCommand deleteSalaryCommand) {
        Salary salary = Salary.builder()
                .id(deleteSalaryCommand.getId())
                .build();
        deleteSalary.deleteSalary(salary);
        return DeleteSalaryCommandResult.builder().status(true).build();
    }
}
