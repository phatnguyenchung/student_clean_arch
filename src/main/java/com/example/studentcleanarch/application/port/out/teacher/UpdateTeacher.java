package com.example.studentcleanarch.application.port.out.teacher;

import com.example.studentcleanarch.domain.Teacher;
import org.springframework.stereotype.Component;

@Component
public interface UpdateTeacher {
    void updateTeacher(Teacher teacher);
}
