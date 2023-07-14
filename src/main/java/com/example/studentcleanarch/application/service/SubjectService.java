package com.example.studentcleanarch.application.service;

import com.example.studentcleanarch.application.port.in.subject.CreateSubjectCommand;
import com.example.studentcleanarch.application.port.in.subject.CreateSubjectCommandResult;
import com.example.studentcleanarch.application.port.in.subject.CreateSubjectUseCase;
import com.example.studentcleanarch.application.port.out.subject.CreateSubject;
import com.example.studentcleanarch.common.UseCase;
import com.example.studentcleanarch.domain.Subject;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
public class SubjectService implements CreateSubjectUseCase {

    private final CreateSubject createSubject;


    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public CreateSubjectCommandResult createSubject(CreateSubjectCommand createSubjectCommand) {
        Subject subject = Subject.builder()
                .subjectId(createSubjectCommand.getSubjectId())
                .subjectName(createSubjectCommand.getSubjectName())
                .startDate(createSubjectCommand.getStartDate())
                .endDate(createSubjectCommand.getEndDate())
                .build();
        if (createSubjectCommand.getStartDate().after(createSubjectCommand.getEndDate())) {
            return CreateSubjectCommandResult.builder().status(false).build();
        } else {
            createSubject.saveSubject(subject);
        }
        return CreateSubjectCommandResult.builder().status(true).build();
    }
}
