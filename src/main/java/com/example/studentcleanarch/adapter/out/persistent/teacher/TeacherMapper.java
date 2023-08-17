package com.example.studentcleanarch.adapter.out.persistent.teacher;

import com.example.studentcleanarch.domain.Teacher;

public class TeacherMapper {

    public static TeacherJpaEntity mapToJpaEntity(Teacher teacher) {
        return TeacherJpaEntity.builder()
                .id(teacher.getId())
                .teacherId(teacher.getTeacherId())
                .teacherFirstName(teacher.getTeacherFirstName())
                .teacherLastName(teacher.getTeacherLastName())
                .joinDate(teacher.getJoinDate())
                .gender(teacher.getGender())
                .cic(teacher.getCic())
                .issuePlace(teacher.getIssuePlace())
                .issueDate(teacher.getIssueDate())
                .expiredDate(teacher.getExpiredDate())
                .birthDate(teacher.getBirthDate())
                .nationality(teacher.getNationality())
                .address(teacher.getAddress())
                .phoneNumber(teacher.getPhoneNumber())
                .active(teacher.getActive())
                .build();
    }

    public static Teacher mapToDomainEntity(TeacherJpaEntity entity) {
        return Teacher.builder()
                .id(entity.getId())
                .teacherId(entity.getTeacherId())
                .teacherFirstName(entity.getTeacherFirstName())
                .teacherLastName(entity.getTeacherLastName())
                .joinDate(entity.getJoinDate())
                .gender(entity.getGender())
                .cic(entity.getCic())
                .issuePlace(entity.getIssuePlace())
                .issueDate(entity.getIssueDate())
                .expiredDate(entity.getExpiredDate())
                .birthDate(entity.getBirthDate())
                .nationality(entity.getNationality())
                .address(entity.getAddress())
                .phoneNumber(entity.getPhoneNumber())
                .active(entity.isActive())
                .build();
    }

    public static TeacherJpaEntity mapToExistedJpaEntity(Teacher teacher, TeacherJpaEntity entity) {
        entity.setId(teacher.getId());
        entity.setTeacherId(teacher.getTeacherId());
        entity.setTeacherFirstName(teacher.getTeacherFirstName());
        entity.setTeacherLastName(teacher.getTeacherLastName());
        entity.setJoinDate(teacher.getJoinDate());
        entity.setGender(teacher.getGender());
        entity.setCic(teacher.getCic());
        entity.setIssuePlace(teacher.getIssuePlace());
        entity.setIssueDate(teacher.getIssueDate());
        entity.setExpiredDate(teacher.getExpiredDate());
        entity.setBirthDate(teacher.getBirthDate());
        entity.setNationality(teacher.getNationality());
        entity.setAddress(teacher.getAddress());
        entity.setPhoneNumber(teacher.getPhoneNumber());
        entity.setActive(teacher.getActive());
        return entity;
    }
}
