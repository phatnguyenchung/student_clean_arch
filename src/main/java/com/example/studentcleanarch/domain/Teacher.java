package com.example.studentcleanarch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class Teacher {
    private Long id;
    private Long teacherId;
    private String teacherFirstName;
    private String teacherLastName;
    private Date joinDate;
    private String gender;
    private String cic;
    private String issuePlace;
    private Date issueDate;
    private Date expiredDate;
    private Date birthDate;
    private String nationality;
    private String address;
    private Boolean active;
}
