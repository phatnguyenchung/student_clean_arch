package com.example.studentcleanarch.application.port.out;

import com.example.studentcleanarch.adapter.out.persistent.student.StudentJpaEntity;

import java.util.List;

public interface SortStudent {

    List<StudentJpaEntity> sortStudentLastNameDesc();

    List<StudentJpaEntity> sortStudentLastNameAsc();
}
