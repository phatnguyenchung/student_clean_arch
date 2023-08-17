package com.example.studentcleanarch.application.port.in.teacher;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Builder
public class CreateTeacherCommand {
    @NotBlank
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
