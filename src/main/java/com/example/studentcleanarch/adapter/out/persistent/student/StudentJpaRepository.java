package com.example.studentcleanarch.adapter.out.persistent.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentJpaEntity, Long>, JpaSpecificationExecutor<StudentJpaEntity> {
    @Query(value = "SELECT * FROM tblStudent WHERE studentLastName LIKE %?1%", nativeQuery = true)
    List<StudentJpaEntity> findByStudentLastName(String studentName);

    @Query(value = "SELECT * FROM tblStudent WHERE phoneNumber LIKE %?1%", nativeQuery = true)
    List<StudentJpaEntity> findByPhoneNumber(Long phoneNumber);

    @Query(value = "SELECT * FROM tblStudent WHERE idNumber LIKE %?1%", nativeQuery = true)
    List<StudentJpaEntity> findByIdNumber(String idNumber);

    @Query(value = "SELECT * FROM tblStudent WHERE className LIKE %?1%", nativeQuery = true)
    List<StudentJpaEntity> findByClassName(String className);

    @Query(value = "SELECT * FROM tblStudent WHERE phoneNumberParent LIKE %?1%", nativeQuery = true)
    List<StudentJpaEntity> findByParentPhoneNumber(Long parentPhoneNumber);

    @Query(value = "SELECT * FROM tblStudent WHERE studentParent LIKE %?1%", nativeQuery = true)
    List<StudentJpaEntity> findByStudentParent(String studentParent);

    @Query(value = "SELECT * FROM tblStudent WHERE jobTitle LIKE %?1%", nativeQuery = true)
    List<StudentJpaEntity> findByJobTitle(String jobTitle);
}
