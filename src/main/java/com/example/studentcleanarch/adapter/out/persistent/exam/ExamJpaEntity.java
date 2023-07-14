package com.example.studentcleanarch.adapter.out.persistent.exam;

import lombok.*;

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

    @Column(name = "ExamDate")
    private Date examDate;

    @Column(name = "Score")
    private int score;
}
