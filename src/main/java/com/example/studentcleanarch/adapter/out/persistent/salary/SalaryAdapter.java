package com.example.studentcleanarch.adapter.out.persistent.salary;


import com.example.studentcleanarch.application.port.out.salary.CreateSalary;
import com.example.studentcleanarch.application.port.out.salary.DeleteSalary;
import com.example.studentcleanarch.application.port.out.salary.GetSalary;
import com.example.studentcleanarch.application.port.out.salary.UpdateSalary;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.common.TimoException;
import com.example.studentcleanarch.domain.Salary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
@Service
public class SalaryAdapter implements CreateSalary, UpdateSalary, DeleteSalary, GetSalary {
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

    @Override
    public void deleteSalary(Salary salary) {
        try {
            Optional<SalaryJpaEntity> salaryJpaEntity = repository.findById(salary.getId());
            salaryJpaEntity.ifPresent(record -> {
                SalaryMapper.mapToExistedJpaEntity(salary, record);
                repository.delete(record);
            });
        } catch (Exception e) {
            throw new TimoException(500, "Salary is not exist!");
        }
    }

    @Override
    public List<Salary> getAllSalary() {
        try {
            List<SalaryJpaEntity> salaryJpaEntityList = repository.findAll();
            for (SalaryJpaEntity entity : salaryJpaEntityList) {
                System.out.println(entity.getId());
            }
            return repository.findAll().stream()
                    .map(SalaryMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Cannot get salary list");
        }
    }

    @Override
    public Salary getSalaryById(Long id) {
        return repository.findById(id)
                .map(SalaryMapper::mapToDomainEntity)
                .orElseThrow(() -> new TimoException(500, "Salary not found id:" + id));
    }
}
