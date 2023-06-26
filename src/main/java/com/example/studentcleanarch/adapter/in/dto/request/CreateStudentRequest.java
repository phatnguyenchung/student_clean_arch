package com.example.studentcleanarch.adapter.in.dto.request;

import com.example.studentcleanarch.application.port.in.CreateStudentCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CreateStudentRequest {
    private Long studentId;
    private String studentName;
    private String className;
    private String gender;
    private Date birthDate;
    private String address;
    private Long phoneNumber;
    private String studentParent;
    private String studentRelation;
    private String jobTitle;
    private Date birthParent;
    private Long phoneNumberParent;

    public CreateStudentCommand toCommand(){
        return CreateStudentCommand.builder()
                .StudentId(studentId)
                .StudentName(studentName)
                .ClassName(className)
                .Gender(gender)
                .BirthDate(birthDate)
                .Address(address)
                .PhoneNumber(phoneNumber)
                .StudentParent(studentParent)
                .StudentRelation(studentRelation)
                .JobTitle(jobTitle)
                .BirthParent(birthParent)
                .PhoneNumberParent(phoneNumberParent)
                .build();
    }
}
