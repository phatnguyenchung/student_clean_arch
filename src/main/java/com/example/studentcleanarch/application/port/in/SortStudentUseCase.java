package com.example.studentcleanarch.application.port.in;

import com.example.studentcleanarch.adapter.out.persistent.student.StudentJpaEntity;
import com.example.studentcleanarch.domain.Student;

import java.util.List;

public interface SortStudentUseCase {

    List<StudentJpaEntity> sortStudentOrderByDesc();
}
