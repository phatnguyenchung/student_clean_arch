package com.example.studentcleanarch.adapter.out.persistent.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SubjectJpaRepository extends JpaRepository<SubjectJpaEntity, Long>, JpaSpecificationExecutor<SubjectJpaEntity> {

    @Query(value = "SELECT * FROM tblSubject WHERE subjectName LIKE %?1%", nativeQuery = true)
    List<SubjectJpaEntity> findBySubjectName(String subjectName);

    @Query(value = "SELECT * FROM tblSubject s WHERE s.StartDate <= :startDate", nativeQuery = true)
    List<SubjectJpaEntity> findByStartDate(@Param("startDate") Date startDate);
}
