package com.example.studentcleanarch.application.port.in.teacher;

import com.example.studentcleanarch.domain.Teacher;

import java.util.List;

public interface GetTeacherUseCase {

    List<Teacher> getAllTeacher();

    Teacher getTeacherById(Long id);
}
