package com.example.studentcleanarch.adapter.out.persistent.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentJpaRepository extends JpaRepository<StudentJpaEntity, Long>, JpaSpecificationExecutor<StudentJpaEntity> {
}
