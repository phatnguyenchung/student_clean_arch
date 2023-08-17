package com.example.studentcleanarch.application.port.out.teacher;

import com.example.studentcleanarch.domain.Teacher;

public interface CreateTeacher {
    Teacher saveTeacher(Teacher teacher);
}
