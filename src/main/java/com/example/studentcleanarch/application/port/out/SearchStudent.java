package com.example.studentcleanarch.application.port.out;

import com.example.studentcleanarch.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchStudent {
    List<Student> searchStudentByLastName(String studentLastName);

    List<Student> searchStudentByPhoneNumber(Long phoneNumber);

    List<Student> searchStudentByIdNumber(String idNumber);

    List<Student> searchStudentByClassName(String className);

    List<Student> searchStudentByParentPhoneNumber(Long parentPhoneNumber);

    List<Student> searchStudentByStudentParent(String studentParent);

    List<Student> searchStudentByJobTitle(String jobTitle);
}
