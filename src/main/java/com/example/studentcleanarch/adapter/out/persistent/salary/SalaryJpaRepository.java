package com.example.studentcleanarch.adapter.out.persistent.salary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryJpaRepository extends JpaRepository<SalaryJpaEntity, Long>, JpaSpecificationExecutor<SalaryJpaEntity> {

    @Query(value = "SELECT * FROM tblSalary WHERE salary LIKE %?1%", nativeQuery = true)
    List<SalaryJpaEntity> findBySalary(int salary);

    @Query(value = "SELECT * FROM tblSalary WHERE teacherId LIKE %?1%", nativeQuery = true)
    List<SalaryJpaEntity> findByTeacherId(Long teacherId);
}
