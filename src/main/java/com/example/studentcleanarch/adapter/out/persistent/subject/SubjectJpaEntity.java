package com.example.studentcleanarch.adapter.out.persistent.subject;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @Column(name = "TeacherId")
    private Long teacherId;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedDate")
    private Date updatedDate;

    @Column(name = "Active")
    private boolean active;
}
