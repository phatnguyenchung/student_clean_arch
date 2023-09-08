package com.example.studentcleanarch.application.port.out.salary;

import com.example.studentcleanarch.domain.Salary;
import org.springframework.stereotype.Component;

@Component
public interface UpdateSalary {
    void updateSalary(Salary salary);
}
