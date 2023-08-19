package com.example.studentcleanarch.application.port.out.teacher;

import com.example.studentcleanarch.adapter.out.persistent.teacher.TeacherJpaEntity;

import java.util.List;

public interface SortTeacher {
    List<TeacherJpaEntity> sortTeacherByIdAsc();

    List<TeacherJpaEntity> sortTeacherByIdDesc();

    List<TeacherJpaEntity> sortTeacherByTeacherIdAsc();

    List<TeacherJpaEntity> sortTeacherByTeacherIdDesc();

    List<TeacherJpaEntity> sortTeacherByTeacherLastNameAsc();

    List<TeacherJpaEntity> sortTeacherByTeacherLastNameDesc();

    List<TeacherJpaEntity> sortTeacherByTeacherFirstNameAsc();

    List<TeacherJpaEntity> sortTeacherByTeacherFirstNameDesc();
}
