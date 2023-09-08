package com.example.studentcleanarch.application.port.out.salary;

import com.example.studentcleanarch.domain.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchSalary {

    List<Salary> searchBySalary(int salary);

    List<Salary> searchByTeacherId(Long teacherId);
}
