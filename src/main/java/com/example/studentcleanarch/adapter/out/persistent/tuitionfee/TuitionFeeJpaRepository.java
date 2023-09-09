package com.example.studentcleanarch.adapter.out.persistent.tuitionfee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TuitionFeeJpaRepository extends JpaRepository<TuitionFeeJpaEntity, Long>, JpaSpecificationExecutor<TuitionFeeJpaEntity> {
}
