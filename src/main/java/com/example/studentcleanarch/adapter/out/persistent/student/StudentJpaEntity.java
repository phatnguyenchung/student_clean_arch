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
public class StudentJpaEntity{

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "StudentId")
    private Long studentId;

    @Column(name = "StudentName")
    private String studentName;

    @Column(name = "ClassName")
    private String className;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "IdNumber")
    private String idNumber;

    @Column(name = "BirthDate")
    private Date birthDate;

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
    @Column(nullable = false, updatable = false, columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date createdDate;
}
