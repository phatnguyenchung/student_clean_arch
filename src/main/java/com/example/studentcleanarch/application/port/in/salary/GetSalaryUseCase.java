package com.example.studentcleanarch.application.port.in.salary;

import com.example.studentcleanarch.domain.Salary;

import java.util.List;

public interface GetSalaryUseCase {
    List<Salary> getAllSalary();

    Salary getSalaryById(Long id);
}
