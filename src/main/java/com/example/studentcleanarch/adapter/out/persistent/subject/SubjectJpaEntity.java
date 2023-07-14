package com.example.studentcleanarch.adapter.out.persistent.subject;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity(name = "Subject")
@Table(name = "tblSubject")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SubjectJpaEntity {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SubjectId")
    private Long subjectId;

    @Column(name = "SubjectName")
    private String subjectName;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;
}
