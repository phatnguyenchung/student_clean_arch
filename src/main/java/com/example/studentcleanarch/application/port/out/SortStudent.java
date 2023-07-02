package com.example.studentcleanarch.application.port.out;

import com.example.studentcleanarch.adapter.out.persistent.student.StudentJpaEntity;
import com.example.studentcleanarch.domain.Student;

import java.util.List;

public interface SortStudent {

    List<StudentJpaEntity> sortStudentDesc();
}
