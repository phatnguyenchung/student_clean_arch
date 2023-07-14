package com.example.studentcleanarch.application.port.out.student;

import com.example.studentcleanarch.adapter.out.persistent.student.StudentJpaEntity;

import java.util.List;

public interface SortStudent {

    List<StudentJpaEntity> sortStudentLastNameDesc();

    List<StudentJpaEntity> sortStudentLastNameAsc();

    List<StudentJpaEntity> sortStudentByIdDesc();

    List<StudentJpaEntity> sortStudentByIdAsc();

    List<StudentJpaEntity> sortStudentByCICDesc();

    List<StudentJpaEntity> sortStudentByCICAsc();

    List<StudentJpaEntity> sortStudentByClassNameDesc();

    List<StudentJpaEntity> sortStudentByClassNameAsc();

    List<StudentJpaEntity> sortStudentByStudentIdDesc();

    List<StudentJpaEntity> sortStudentByStudentIdAsc();

    List<StudentJpaEntity> sortStudentByAdmissionDateDesc();

    List<StudentJpaEntity> sortStudentByAdmissionDateAsc();

    List<StudentJpaEntity> sortStudentByCreatedDateDesc();

    List<StudentJpaEntity> sortStudentByCreatedDateAsc();

    List<StudentJpaEntity> sortStudentByJobTitleDesc();

    List<StudentJpaEntity> sortStudentByJobTitleAsc();

    List<StudentJpaEntity> sortStudentFirstNameDesc();

    List<StudentJpaEntity> sortStudentFirstNameAsc();

    List<StudentJpaEntity> sortStudentByNationalityDesc();

    List<StudentJpaEntity> sortStudentByNationalityAsc();
}
