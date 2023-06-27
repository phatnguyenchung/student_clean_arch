package com.example.studentcleanarch.adapter.in.dto.request;

import com.example.studentcleanarch.application.port.in.UpdateStudentCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UpdateStudentRequest {
    private Long id;
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

    public UpdateStudentCommand toCommand(){
        return UpdateStudentCommand.builder()
                .id(id)
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
