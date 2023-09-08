package com.example.studentcleanarch.adapter.out.persistent.salary;

import com.example.studentcleanarch.application.port.out.salary.CreateSalary;
import com.example.studentcleanarch.application.port.out.salary.UpdateSalary;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.domain.Salary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
@Service
public class SalaryAdapter implements CreateSalary, UpdateSalary {
    private final SalaryJpaRepository repository;

    @Override
    public Salary saveSalary(Salary salary) {
        SalaryJpaEntity salaryJpaEntity = repository.save(SalaryMapper.mapToJpaEntity(salary));
        return SalaryMapper.mapToDomainEntity(salaryJpaEntity);
    }

    @Override
    public void updateSalary(Salary salary) {
        Optional<SalaryJpaEntity> salaryJpaEntity = repository.findById(salary.getId());
        salaryJpaEntity.ifPresent(record -> {
            SalaryMapper.mapToExistedJpaEntity(salary, record);
            repository.save(record);
        });
    }
}
