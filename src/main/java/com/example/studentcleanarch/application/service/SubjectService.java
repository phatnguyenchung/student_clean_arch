package com.example.studentcleanarch.application.service;

import com.example.studentcleanarch.adapter.out.persistent.subject.SubjectJpaEntity;
import com.example.studentcleanarch.application.port.in.subject.*;
import com.example.studentcleanarch.application.port.out.subject.*;
import com.example.studentcleanarch.common.UseCase;
import com.example.studentcleanarch.domain.Subject;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class SubjectService implements CreateSubjectUseCase, UpdateSubjectUseCase, DeleteSubjectUseCase, GetSubjectUseCase, SearchSubjectUseCase, SortSubjectUseCase {

    private final CreateSubject createSubject;
    private final UpdateSubject updateSubject;
    private final DeleteSubject deleteSubject;
    private final GetSubject getSubject;
    private final SearchSubject searchSubject;
    private final SortSubject sortSubject;

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public CreateSubjectCommandResult createSubject(CreateSubjectCommand createSubjectCommand) {
        Subject subject = Subject.builder()
                .subjectId(createSubjectCommand.getSubjectId())
                .subjectName(createSubjectCommand.getSubjectName())
                .teacherId(createSubjectCommand.getTeacherId())
                .startDate(createSubjectCommand.getStartDate())
                .endDate(createSubjectCommand.getEndDate())
                .active(createSubjectCommand.getActive())
                .build();
        if (createSubjectCommand.getStartDate().after(createSubjectCommand.getEndDate()) &&
                createSubjectCommand.getStartDate().before(Date.from(Instant.now()))) {
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
                .teacherId(updateSubjectCommand.getTeacherId())
                .startDate(updateSubjectCommand.getStartDate())
                .endDate(updateSubjectCommand.getEndDate())
                .active(updateSubjectCommand.getActive())
                .build();
        if (updateSubjectCommand.getStartDate().after(updateSubjectCommand.getEndDate()) &&
                updateSubjectCommand.getStartDate().before(Date.from(Instant.now()))) {
            return UpdateSubjectCommandResult.builder().status(false).build();
        } else {
            updateSubject.updateSubject(subject);
        }
        return UpdateSubjectCommandResult.builder().status(true).build();
    }

    @Override
    public DeleteSubjectCommandResult deleteSubject(DeleteSubjectCommand deleteSubjectCommand) {
        Subject subject = Subject.builder()
                .id(deleteSubjectCommand.getId())
                .build();
        deleteSubject.deleteSubject(subject);
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

    @Override
    public List<Subject> searchSubject(String subject) {
        return searchSubject.searchSubject(subject);
    }

    @Override
    public List<Subject> searchSubjectByStartDate(Date startDate) {
        return searchSubject.searchSubjectByStartDate(startDate);
    }

    @Override
    public List<SubjectJpaEntity> sortSubjectNameOrderByDesc() {
        return sortSubject.sortSubjectNameDesc();
    }

    @Override
    public List<SubjectJpaEntity> sortSubjectNameOrderByAsc() {
        return sortSubject.sortSubjectNameAsc();
    }

    @Override
    public List<SubjectJpaEntity> sortIdByDesc() {
        return sortSubject.sortIdDesc();
    }

    @Override
    public List<SubjectJpaEntity> sortIdByAsc() {
        return sortSubject.sortIdAsc();
    }

    @Override
    public List<SubjectJpaEntity> sortStartDateDesc() {
        return sortSubject.sortStartDateDesc();
    }

    @Override
    public List<SubjectJpaEntity> sortStartDateAsc() {
        return sortSubject.sortStartDateAsc();
    }

    @Override
    public List<SubjectJpaEntity> sortEndDateDesc() {
        return sortSubject.sortEndDateDesc();
    }

    @Override
    public List<SubjectJpaEntity> sortEndDateAsc() {
        return sortSubject.sortEndDateAsc();
    }
}
