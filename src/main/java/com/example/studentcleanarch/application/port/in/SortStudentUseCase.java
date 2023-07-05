package com.example.studentcleanarch.application.port.in;

import com.example.studentcleanarch.adapter.out.persistent.student.StudentJpaEntity;

import java.util.List;

public interface SortStudentUseCase {

    List<StudentJpaEntity> sortStudentLastNameOrderByDesc();

    List<StudentJpaEntity> sortStudentLastNameOrderByAsc();

    List<StudentJpaEntity> sortStudentByIdDesc();

    List<StudentJpaEntity> sortStudentByIdAsc();
}
