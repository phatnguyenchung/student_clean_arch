package com.example.studentcleanarch.adapter.out.persistent.exam;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamJpaRepository extends JpaRepository<ExamJpaEntity, Long>, JpaSpecificationExecutor<ExamJpaEntity> {
}
