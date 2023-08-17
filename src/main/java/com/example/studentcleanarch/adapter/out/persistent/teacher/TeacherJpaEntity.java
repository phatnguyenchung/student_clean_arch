package com.example.studentcleanarch.adapter.out.persistent.teacher;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity(name = "Teacher")
@Table(name = "tblTeacher")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TeacherJpaEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TeacherId")
    private Long teacherId;

    @Column(name = "TeacherFirstName")
    private String teacherFirstName;

    @Column(name = "TeacherLastName")
    private String teacherLastName;

    @Column(name = "JoinDate")
    private Date joinDate;

    @Column(name = "Gender")
    private String gender;

    @Column(name = " CIC")
    private String cic;

    @Column(name = "IssuePlace")
    private String issuePlace;

    @Column(name = "IssueDate")
    private Date issueDate;

    @Column(name = "ExpiredDate")
    private Date expiredDate;

    @Column(name = "BirthDate")
    private Date birthDate;

    @Column(name = "Nationality")
    private String nationality;

    @Column(name = "Address")
    private String address;

    @Column(name = "Active")
    private boolean active;
}
