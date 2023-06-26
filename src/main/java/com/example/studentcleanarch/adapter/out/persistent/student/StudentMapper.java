package com.example.studentcleanarch.adapter.out.persistent.student;

import com.example.studentcleanarch.domain.Student;

public class StudentMapper {

    public static StudentJpaEntity mapToJpaEntity(Student student){
        return StudentJpaEntity.builder()
                .id(student.getId())
                .studentId(student.getStudentId())
                .studentName(student.getStudentName())
                .className(student.getClassName())
                .gender(student.getGender())
                .birthDate(student.getBirthDate())
                .address(student.getAddress())
                .phoneNumber(student.getPhoneNumber())
                .studentParent(student.getStudentParent())
                .studentRelation(student.getStudentRelation())
                .jobTitle(student.getJobTitle())
                .birthParent(student.getBirthParent())
                .phoneNumberParent(student.getPhoneNumberParent())
                .build();
    }

    public static Student mapToDomainEntity(StudentJpaEntity entity){
        return Student.builder()
                .id(entity.getId())
                .studentId(entity.getStudentId())
                .studentName(entity.getStudentName())
                .className(entity.getClassName())
                .gender(entity.getGender())
                .birthDate(entity.getBirthDate())
                .address(entity.getAddress())
                .phoneNumber(entity.getPhoneNumber())
                .studentParent(entity.getStudentParent())
                .studentRelation(entity.getStudentRelation())
                .jobTitle(entity.getJobTitle())
                .birthParent(entity.getBirthParent())
                .phoneNumberParent(entity.getPhoneNumberParent())
                .build();
    }
}
