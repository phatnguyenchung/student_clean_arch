package com.example.studentcleanarch.application.port.in;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Builder
public class CreateStudentCommand {
    @NotBlank
    private String StudentId;
    private String StudentName;
    private String ClassName;
    private String Gender;
    private Date BirthDate;
    private String Address;
    private Long PhoneNumber;
    private String StudentParent;
    private String StudentRelation;
    private String JobTitle;
    private Date BirthParent;
    private Long PhoneNumberParent;
}
