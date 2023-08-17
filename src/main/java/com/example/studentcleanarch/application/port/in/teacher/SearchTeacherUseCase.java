package com.example.studentcleanarch.application.port.in.teacher;

import com.example.studentcleanarch.domain.Teacher;

import java.util.List;

public interface SearchTeacherUseCase {
    List<Teacher> searchTeacherByLastName(String teacherLastName);

    List<Teacher> searchTeacherByCIC(String CIC);

    List<Teacher> searchTeacherByAddress(String address);

    List<Teacher> searchTeacherByPhoneNumber(String phoneNumber);
}
