package com.example.studentcleanarch.adapter.out.persistent.salary;


import com.example.studentcleanarch.application.port.out.salary.*;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.common.TimoException;
import com.example.studentcleanarch.domain.Salary;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
@Service
public class SalaryAdapter implements CreateSalary, UpdateSalary, DeleteSalary, GetSalary, SearchSalary, SortSalary {
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

    @Override
    public List<Salary> searchBySalary(int salary) {
        try {
            List<SalaryJpaEntity> salaryJpaEntityList = repository.findBySalary(salary);
            for (SalaryJpaEntity entity : salaryJpaEntityList) {
                System.out.println(entity.getId());
            }
            return repository.findBySalary(salary).stream()
                    .map(SalaryMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Salary could not found:" + salary);
        }
    }

    @Override
    public List<Salary> searchByTeacherId(Long teacherId) {
        try {
            List<SalaryJpaEntity> salaryJpaEntityList = repository.findByTeacherId(teacherId);
            for (SalaryJpaEntity entity : salaryJpaEntityList) {
                System.out.println(entity.getId());
            }
            return repository.findByTeacherId(teacherId).stream()
                    .map(SalaryMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Salary could not found teacher id:" + teacherId);
        }
    }

    @Override
    public List<SalaryJpaEntity> sortByIdDesc() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public List<SalaryJpaEntity> sortByIdAsc() {
        return repository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "id"));
    }

    @Override
    public List<SalaryJpaEntity> sortByTeacherIdDesc() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "teacherId"));
    }

    @Override
    public List<SalaryJpaEntity> sortByTeacherIdAsc() {
        return repository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "teacherId"));
    }

    @Override
    public List<SalaryJpaEntity> sortBySalaryDesc() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "salary"));
    }

    @Override
    public List<SalaryJpaEntity> sortBySalaryAsc() {
        return repository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "salary"));
    }
}
