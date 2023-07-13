package com.example.studentcleanarch.adapter.out.persistent.student;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity(name = "Student")
@Table(name = "tblStudent")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class StudentJpaEntity {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "StudentId")
    private Long studentId;

    @Column(name = "StudentFirstName")
    private String studentFirstName;

    @Column(name = "StudentLastName")
    private String studentLastName;

    @Column(name = "ClassName")
    private String className;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date joinDate;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "CIC")
    private String cic;

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

    @Column(name = "PhoneNumber")
    private Long phoneNumber;

    @Column(name = "StudentParent")
    private String studentParent;

    @Column(name = "StudentRelation")
    private String studentRelation;

    @Column(name = "JobTitle")
    private String jobTitle;

    @Column(name = "BirthParent")
    private Date birthParent;

    @Column(name = "PhoneNumberParent")
    private Long phoneNumberParent;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date createdDate;

    @Column(name = "AdmissionDate")
    private Date admissionDate;

    @Column(name = "Active")
    private Boolean active;
}
