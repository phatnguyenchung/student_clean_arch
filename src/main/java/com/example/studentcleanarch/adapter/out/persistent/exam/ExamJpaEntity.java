package com.example.studentcleanarch.adapter.out.persistent.exam;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity(name = "Exam")
@Table(name = "tblExam")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ExamJpaEntity {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "StudentId")
    private Long studentId;

    @Column(name = "SubjectId")
    private Long subjectId;

    @Column(name = "TeacherId")
    private Long teacherId;

    @Column(name = "ExamDate")
    private Date examDate;

    @Column(name = "Score")
    private int score;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedDate")
    private Date updatedDate;
}
