package com.example.studentcleanarch.application.port.out.salary;

import com.example.studentcleanarch.domain.Salary;

public interface CreateSalary {
    Salary saveSalary(Salary salary);
}
