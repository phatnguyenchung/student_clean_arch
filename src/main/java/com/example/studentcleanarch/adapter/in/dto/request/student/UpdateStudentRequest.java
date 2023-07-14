package com.example.studentcleanarch.adapter.in.dto.request.student;

import com.example.studentcleanarch.application.port.in.student.UpdateStudentCommand;
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
    private String studentFirstName;
    private String studentLastName;
    private String className;
    private String cic;
    private String issuePlace;
    private Date issueDate;
    private Date expiredDate;
    private String gender;
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
    private boolean active;

    public UpdateStudentCommand toCommand() {
        return UpdateStudentCommand.builder()
                .id(id)
                .StudentId(studentId)
                .StudentFirstName(studentFirstName)
                .StudentLastName(studentLastName)
                .ClassName(className)
                .CIC(cic)
                .IssuePlace(issuePlace)
                .IssueDate(issueDate)
                .ExpiredDate(expiredDate)
                .Gender(gender)
                .BirthDate(birthDate)
                .Nationality(nationality)
                .Address(address)
                .PhoneNumber(phoneNumber)
                .StudentParent(studentParent)
                .StudentRelation(studentRelation)
                .JobTitle(jobTitle)
                .BirthParent(birthParent)
                .PhoneNumberParent(phoneNumberParent)
                .AdmissionDate(admissionDate)
                .Active(active)
                .build();
    }
}
