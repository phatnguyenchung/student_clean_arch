package com.example.studentcleanarch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class Salary {
    private Long id;
    private Long teacherId;
    private int salary;
    private Date salaryDate;
    private Boolean salaryGiven;
}
