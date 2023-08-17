package com.example.studentcleanarch.adapter.out.persistent.teacher;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherJpaRepository extends JpaRepository<TeacherJpaEntity, Long>, JpaSpecificationExecutor<TeacherJpaEntity> {
}
