package com.example.studentcleanarch.application.service;

import com.example.studentcleanarch.application.port.in.subject.*;
import com.example.studentcleanarch.application.port.out.subject.CreateSubject;
import com.example.studentcleanarch.application.port.out.subject.DeleteSubject;
import com.example.studentcleanarch.application.port.out.subject.GetSubject;
import com.example.studentcleanarch.application.port.out.subject.UpdateSubject;
import com.example.studentcleanarch.common.UseCase;
import com.example.studentcleanarch.domain.Subject;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class SubjectService implements CreateSubjectUseCase, UpdateSubjectUseCase, DeleteSubjectUseCase, GetSubjectUseCase {

    private final CreateSubject createSubject;
    private final UpdateSubject updateSubject;
    private final DeleteSubject deleteSubject;
    private final GetSubject getSubject;

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

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public UpdateSubjectCommandResult updateSubject(UpdateSubjectCommand updateSubjectCommand) {
        Subject subject = Subject.builder()
                .id(updateSubjectCommand.getId())
                .subjectId(updateSubjectCommand.getSubjectId())
                .subjectName(updateSubjectCommand.getSubjectName())
                .startDate(updateSubjectCommand.getStartDate())
                .endDate(updateSubjectCommand.getEndDate())
                .build();
        if (updateSubjectCommand.getStartDate().after(updateSubjectCommand.getEndDate())) {
            return UpdateSubjectCommandResult.builder().status(false).build();
        } else {
            updateSubject.updateSubject(subject);
        }
        return UpdateSubjectCommandResult.builder().status(true).build();
    }

    @Override
    public DeleteSubjectCommandResult deleteSubject(Long id) {
        deleteSubject.deleteSubject(id);
        return DeleteSubjectCommandResult.builder().status(true).build();
    }

    @Override
    public List<Subject> getAllSubject() {
        return getSubject.getAllSubject();
    }

    @Override
    public Subject getSubjectById(Long id) {
        return getSubject.getSubjectById(id);
    }
}
