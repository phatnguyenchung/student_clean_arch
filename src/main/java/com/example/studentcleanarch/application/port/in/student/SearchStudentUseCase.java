package com.example.studentcleanarch.application.port.in.student;

import com.example.studentcleanarch.domain.Student;

import java.util.List;

public interface SearchStudentUseCase {

    List<Student> searchStudentByStudentLastName(String studentLastName);

    List<Student> searchStudentByStudentFirstName(String studentFirstName);

    List<Student> searchStudentByPhoneNumber(Long phoneNumber);

    List<Student> searchStudentByCIC(String cic);

    List<Student> searchStudentByClassName(String className);

    List<Student> searchStudentByParentPhoneNumber(Long parentPhoneNumber);

    List<Student> searchStudentByStudentParent(String studentParent);

    List<Student> searchStudentByJobTitle(String jobTitle);

    List<Student> searchStudentByStudentId(Long studentId);

    List<Student> searchStudentByNationality(String nationality);

    List<Student> searchStudentByAddress(String address);
}
