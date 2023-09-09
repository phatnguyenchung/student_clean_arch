package com.example.studentcleanarch.adapter.out.persistent.salary;

import com.example.studentcleanarch.domain.Salary;

public class SalaryMapper {

    public static SalaryJpaEntity mapToJpaEntity(Salary salary) {
        return SalaryJpaEntity.builder()
                .id(salary.getId())
                .teacherId(salary.getTeacherId())
                .salary(salary.getSalary())
                .bonus(salary.getBonus())
                .salaryDate(salary.getSalaryDate())
                .salaryGiven(salary.getSalaryGiven())
                .build();
    }

    public static Salary mapToDomainEntity(SalaryJpaEntity entity) {
        return Salary.builder()
                .id(entity.getId())
                .teacherId(entity.getTeacherId())
                .salary(entity.getSalary())
                .bonus(entity.getBonus())
                .salaryDate(entity.getSalaryDate())
                .salaryGiven(entity.getSalaryGiven())
                .build();
    }

    public static SalaryJpaEntity mapToExistedJpaEntity(Salary salary, SalaryJpaEntity entity) {
        entity.setId(salary.getId());
        entity.setTeacherId(salary.getTeacherId());
        entity.setSalary(salary.getSalary());
        entity.setBonus(salary.getBonus());
        entity.setSalaryDate(salary.getSalaryDate());
        entity.setSalaryGiven(salary.getSalaryGiven());
        return entity;
    }
}
