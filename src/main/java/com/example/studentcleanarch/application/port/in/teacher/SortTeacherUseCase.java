package com.example.studentcleanarch.application.port.in.teacher;

import com.example.studentcleanarch.adapter.out.persistent.teacher.TeacherJpaEntity;

import java.util.List;

public interface SortTeacherUseCase {

    List<TeacherJpaEntity> sortTeacherByIdAsc();

    List<TeacherJpaEntity> sortTeacherByIdDesc();

    List<TeacherJpaEntity> sortTeacherByTeacherIdAsc();

    List<TeacherJpaEntity> sortTeacherByTeacherIdDesc();

    List<TeacherJpaEntity> sortTeacherByTeacherLastNameAsc();

    List<TeacherJpaEntity> sortTeacherByTeacherLastNameDesc();

    List<TeacherJpaEntity> sortTeacherByTeacherFirstNameAsc();

    List<TeacherJpaEntity> sortTeacherByTeacherFirstNameDesc();
}
