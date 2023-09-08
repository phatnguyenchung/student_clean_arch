package com.example.studentcleanarch.adapter.out.persistent.salary;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity(name = "Salary")
@Table(name = "tblSalary")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SalaryJpaEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TeacherId")
    private Long teacherId;

    @Column(name = "Salary")
    private int salary;

    @Column(name = "SalaryDate")
    private Date salaryDate;

    @Column(name = "SalaryGiven")
    private Boolean salaryGiven;
}
