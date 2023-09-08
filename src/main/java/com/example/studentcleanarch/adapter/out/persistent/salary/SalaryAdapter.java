package com.example.studentcleanarch.adapter.out.persistent.salary;

import com.example.studentcleanarch.application.port.out.salary.CreateSalary;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.domain.Salary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@PersistenceAdapter
@RequiredArgsConstructor
@Service
public class SalaryAdapter implements CreateSalary {
    private final SalaryJpaRepository repository;

    @Override
    public Salary saveSalary(Salary salary) {
        SalaryJpaEntity salaryJpaEntity = repository.save(SalaryMapper.mapToJpaEntity(salary));
        return SalaryMapper.mapToDomainEntity(salaryJpaEntity);
    }
}
