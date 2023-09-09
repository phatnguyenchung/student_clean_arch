package com.example.studentcleanarch.adapter.out.persistent.tuitionfee;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity(name = "TuitionFee")
@Table(name = "tblTuitionFee")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TuitionFeeJpaEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "StudentId")
    private Long studentId;

    @Column(name = "TeacherId")
    private Long teacherId;

    @Column(name = "SubjectId")
    private Long subjectId;

    @Column(name = "Fee")
    private int fee;

    @Column(name = "FeeDate")
    private Date feeDate;
}
