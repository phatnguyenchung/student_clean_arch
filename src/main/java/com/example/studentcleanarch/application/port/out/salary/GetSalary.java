package com.example.studentcleanarch.application.port.out.salary;

import com.example.studentcleanarch.domain.Salary;

import java.util.List;

public interface GetSalary {
    List<Salary> getAllSalary();

    Salary getSalaryById(Long id);
}
