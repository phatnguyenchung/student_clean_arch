package com.example.studentcleanarch.application.port.in.salary;

import com.example.studentcleanarch.domain.Salary;

import java.util.List;

public interface SearchSalaryUseCase {
    List<Salary> searchBySalary(int salary);

    List<Salary> searchByTeacherId(Long teacherId);
}
