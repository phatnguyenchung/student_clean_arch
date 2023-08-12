package com.example.studentcleanarch.application.port.in.student;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Builder
public class UpdateStudentCommand {
    private Long id;
    @NotBlank
    private Long StudentId;
    private String StudentFirstName;
    private String StudentLastName;
    private String ClassName;
    private String Gender;
    private String CIC;
    private String IssuePlace;
    private Date IssueDate;
    private Date ExpiredDate;
    private Date BirthDate;
    private String Nationality;
    private String Address;
    private Long PhoneNumber;
    private String StudentParent;
    private String StudentRelation;
    private String JobTitle;
    private Date BirthParent;
    private String AddressParent;
    private Long PhoneNumberParent;
    private Date AdmissionDate;
    private Boolean Active;
}
