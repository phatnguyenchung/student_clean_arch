package com.example.studentcleanarch.adapter.out.persistent.exam;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamJpaRepository extends JpaRepository<ExamJpaEntity, Long>, JpaSpecificationExecutor<ExamJpaEntity> {

    @Query(value = "SELECT * FROM tblExam WHERE studentId LIKE %?1%", nativeQuery = true)
    List<ExamJpaEntity> findByStudentId(Long studentId);

    @Query(value = "SELECT * FROM tblExam WHERE subjectId LIKE %?1%", nativeQuery = true)
    List<ExamJpaEntity> findBySubjectId(Long subjectId);
}
