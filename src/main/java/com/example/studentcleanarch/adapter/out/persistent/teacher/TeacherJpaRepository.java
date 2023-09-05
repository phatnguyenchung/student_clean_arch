package com.example.studentcleanarch.adapter.out.persistent.teacher;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherJpaRepository extends JpaRepository<TeacherJpaEntity, Long>, JpaSpecificationExecutor<TeacherJpaEntity> {
    @Query(value = "SELECT * FROM tblTeacher WHERE teacherLastName LIKE %?1%", nativeQuery = true)
    List<TeacherJpaEntity> searchTeacherByLastName(String teacherLastName);

    @Query(value = "SELECT * FROM tblTeacher WHERE teacherFirstName LIKE %?1%", nativeQuery = true)
    List<TeacherJpaEntity> searchTeacherByFirstName(String teacherFirstName);

    @Query(value = "SELECT * FROM tblTeacher WHERE CIC LIKE %?1%", nativeQuery = true)
    List<TeacherJpaEntity> searchTeacherByCIC(String cic);

    @Query(value = "SELECT * FROM tblTeacher WHERE address LIKE %?1%", nativeQuery = true)
    List<TeacherJpaEntity> searchTeacherByAddress(String address);

    @Query(value = "SELECT * FROM tblTeacher WHERE phoneNumber LIKE %?1%", nativeQuery = true)
    List<TeacherJpaEntity> searchTeacherByPhoneNumber(String phoneNumber);

}
