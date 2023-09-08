package com.example.studentcleanarch.application.port.out.salary;

import com.example.studentcleanarch.adapter.out.persistent.salary.SalaryJpaEntity;

import java.util.List;

public interface SortSalary {
    List<SalaryJpaEntity> sortByIdDesc();

    List<SalaryJpaEntity> sortByIdAsc();

    List<SalaryJpaEntity> sortByTeacherIdDesc();

    List<SalaryJpaEntity> sortByTeacherIdAsc();

    List<SalaryJpaEntity> sortBySalaryDesc();

    List<SalaryJpaEntity> sortBySalaryAsc();
}
