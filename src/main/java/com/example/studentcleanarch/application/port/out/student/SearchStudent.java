package com.example.studentcleanarch.application.port.out.student;

import com.example.studentcleanarch.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchStudent {

    List<Student> searchStudentByFirstName(String studentFirstName);

    List<Student> searchStudentByLastName(String studentLastName);

    List<Student> searchStudentByPhoneNumber(Long phoneNumber);

    List<Student> searchStudentByCIC(String CIC);

    List<Student> searchStudentByClassName(String className);

    List<Student> searchStudentByParentPhoneNumber(Long parentPhoneNumber);

    List<Student> searchStudentByStudentParent(String studentParent);

    List<Student> searchStudentByJobTitle(String jobTitle);

    List<Student> searchStudentByStudentId(Long studentId);

    List<Student> searchStudentByNationality(String nationality);

    List<Student> searchStudentByAddress(String address);
}
