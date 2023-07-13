package com.example.studentcleanarch.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class Student {
    private Long id;
    private Long studentId;
    private String studentFirstName;
    private String studentLastName;
    private String className;
    private String gender;
    private String cic;
    private Date issueDate;
    private Date expiredDate;
    private Date birthDate;
    private String nationality;
    private String address;
    private Long phoneNumber;
    private String studentParent;
    private String studentRelation;
    private String jobTitle;
    private Date birthParent;
    private Long phoneNumberParent;
    private Date admissionDate;
    private Boolean active;
}
