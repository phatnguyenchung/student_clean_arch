package com.example.studentcleanarch.application.port.out.teacher;

import com.example.studentcleanarch.domain.Teacher;

import java.util.List;

public interface GetTeacher {
    List<Teacher> getAllTeacher();

    Teacher getTeacherById(Long id);
}
