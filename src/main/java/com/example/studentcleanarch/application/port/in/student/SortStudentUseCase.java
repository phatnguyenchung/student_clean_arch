package com.example.studentcleanarch.application.port.in.student;

import com.example.studentcleanarch.adapter.out.persistent.student.StudentJpaEntity;

import java.util.List;

public interface SortStudentUseCase {

    List<StudentJpaEntity> sortStudentLastNameOrderByDesc();

    List<StudentJpaEntity> sortStudentLastNameOrderByAsc();

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

    List<StudentJpaEntity> sortStudentByFirstNameDesc();

    List<StudentJpaEntity> sortStudentByFirstNameAsc();

    List<StudentJpaEntity> sortStudentByNationalityDesc();

    List<StudentJpaEntity> sortStudentByNationalityAsc();

    List<StudentJpaEntity> sortStudentByBirthDateDesc();

    List<StudentJpaEntity> sortStudentByBirthDateAsc();
}
