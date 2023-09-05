package com.example.studentcleanarch.application.port.out.teacher;

import com.example.studentcleanarch.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchTeacher {

    List<Teacher> searchTeacherByLastName(String teacherLastName);

    List<Teacher> searchTeacherByFirstName(String teacherFirstName);

    List<Teacher> searchTeacherByCIC(String CIC);

    List<Teacher> searchTeacherByAddress(String address);

    List<Teacher> searchTeacherByPhoneNumber(String phoneNumber);
}
