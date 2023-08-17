package com.example.studentcleanarch.adapter.in.dto.request.teacher;

import com.example.studentcleanarch.application.port.in.teacher.CreateTeacherCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CreateTeacherRequest {
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
    private String phoneNumber;
    private Boolean active;

    public CreateTeacherCommand toCommand() {
        return CreateTeacherCommand.builder()
                .teacherId(teacherId)
                .teacherFirstName(teacherFirstName)
                .teacherLastName(teacherLastName)
                .joinDate(joinDate)
                .gender(gender)
                .cic(cic)
                .issuePlace(issuePlace)
                .issueDate(issueDate)
                .expiredDate(expiredDate)
                .birthDate(birthDate)
                .nationality(nationality)
                .address(address)
                .phoneNumber(phoneNumber)
                .active(active)
                .build();
    }
}
