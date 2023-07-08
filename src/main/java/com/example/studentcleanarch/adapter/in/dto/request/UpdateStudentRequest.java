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
    private String studentFirstName;
    private String studentLastName;
    private String className;
    private String cic;
    private String gender;
    private Date birthDate;
    private String address;
    private Long phoneNumber;
    private String studentParent;
    private String studentRelation;
    private String jobTitle;
    private Date birthParent;
    private Long phoneNumberParent;
    private Date admissionDate;

    public UpdateStudentCommand toCommand() {
        return UpdateStudentCommand.builder()
                .id(id)
                .StudentId(studentId)
                .StudentFirstName(studentFirstName)
                .StudentLastName(studentLastName)
                .ClassName(className)
                .CIC(cic)
                .Gender(gender)
                .BirthDate(birthDate)
                .Address(address)
                .PhoneNumber(phoneNumber)
                .StudentParent(studentParent)
                .StudentRelation(studentRelation)
                .JobTitle(jobTitle)
                .BirthParent(birthParent)
                .PhoneNumberParent(phoneNumberParent)
                .AdmissionDate(admissionDate)
                .build();
    }
}
