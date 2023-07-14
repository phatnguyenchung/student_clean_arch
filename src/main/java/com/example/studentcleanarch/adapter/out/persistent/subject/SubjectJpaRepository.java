package com.example.studentcleanarch.adapter.out.persistent.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SubjectJpaRepository extends JpaRepository<SubjectJpaEntity, Long>, JpaSpecificationExecutor<SubjectJpaEntity> {
}
