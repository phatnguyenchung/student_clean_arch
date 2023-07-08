package com.example.studentcleanarch.application.port.out;

import com.example.studentcleanarch.adapter.out.persistent.student.StudentJpaEntity;

import java.util.List;

public interface SortStudent {

    List<StudentJpaEntity> sortStudentLastNameDesc();

    List<StudentJpaEntity> sortStudentLastNameAsc();

    List<StudentJpaEntity> sortStudentByIdDesc();

    List<StudentJpaEntity> sortStudentByIdAsc();

    List<StudentJpaEntity> sortStudentByIdNumberDesc();

    List<StudentJpaEntity> sortStudentByIdNumberAsc();

    List<StudentJpaEntity> sortStudentByClassNameDesc();

    List<StudentJpaEntity> sortStudentByClassNameAsc();

    List<StudentJpaEntity> sortStudentByStudentIdDesc();

    List<StudentJpaEntity> sortStudentByStudentIdAsc();
}
