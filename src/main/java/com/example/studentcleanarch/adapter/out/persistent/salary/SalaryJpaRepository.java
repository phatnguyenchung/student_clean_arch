package com.example.studentcleanarch.adapter.out.persistent.salary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryJpaRepository extends JpaRepository<SalaryJpaEntity, Long>, JpaSpecificationExecutor<SalaryJpaEntity> {
}
