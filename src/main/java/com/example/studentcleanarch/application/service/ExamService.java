package com.example.studentcleanarch.application.service;

import com.example.studentcleanarch.application.port.in.exam.CreateExamCommand;
import com.example.studentcleanarch.application.port.in.exam.CreateExamCommandResult;
import com.example.studentcleanarch.application.port.in.exam.CreateExamUseCase;
import com.example.studentcleanarch.application.port.out.exam.CreateExam;
import com.example.studentcleanarch.common.UseCase;
import com.example.studentcleanarch.domain.Exam;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
public class ExamService implements CreateExamUseCase {
    private final CreateExam createExam;

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public CreateExamCommandResult createExam(CreateExamCommand createExamCommand) {
        Exam exam = Exam.builder()
                .studentId(createExamCommand.getStudentId())
                .subjectId(createExamCommand.getSubjectId())
                .examDate(createExamCommand.getExamDate())
                .score(createExamCommand.getScore())
                .build();
        createExam.saveExam(exam);
        return CreateExamCommandResult.builder().status(true).build();
    }
}
