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
                .idNumber(student.getIdNumber())
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
                .idNumber(entity.getIdNumber())
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

    public static StudentJpaEntity mapToExistedJpaEntity(Student student, StudentJpaEntity entity){
        entity.setId(student.getId());
        entity.setStudentId(student.getStudentId());
        entity.setStudentName(student.getStudentName());
        entity.setClassName(student.getClassName());
        entity.setGender(student.getGender());
        entity.setIdNumber(student.getIdNumber());
        entity.setBirthDate(student.getBirthDate());
        entity.setAddress(student.getAddress());
        entity.setPhoneNumber(student.getPhoneNumber());
        entity.setStudentParent(student.getStudentParent());
        entity.setStudentRelation(student.getStudentRelation());
        entity.setJobTitle(student.getJobTitle());
        entity.setBirthParent(student.getBirthParent());
        entity.setPhoneNumberParent(student.getPhoneNumberParent());
        return entity;
    }
}
