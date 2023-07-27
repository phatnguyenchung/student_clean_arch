package com.example.studentcleanarch.application.service;

import com.example.studentcleanarch.adapter.out.persistent.exam.ExamJpaEntity;
import com.example.studentcleanarch.application.port.in.exam.*;
import com.example.studentcleanarch.application.port.out.exam.*;
import com.example.studentcleanarch.common.UseCase;
import com.example.studentcleanarch.domain.Exam;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ExamService implements CreateExamUseCase, UpdateExamUseCase, DeleteExamUseCase, SortExamUseCase, SearchExamUseCase {
    private final CreateExam createExam;
    private final UpdateExam updateExam;
    private final DeleteExam deleteExam;
    private final SortExam sortExam;
    private final SearchExam searchExam;

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public CreateExamCommandResult createExam(CreateExamCommand createExamCommand) {
        Exam exam = Exam.builder()
                .studentId(createExamCommand.getStudentId())
                .subjectId(createExamCommand.getSubjectId())
                .examDate(createExamCommand.getExamDate())
                .score(createExamCommand.getScore())
                .build();
        if (createExamCommand.getScore() > 10 || createExamCommand.getScore() < 0) {
            return CreateExamCommandResult.builder().status(false).build();
        } else if (createExamCommand.getExamDate().after(Date.from(Instant.now()))) {
            return CreateExamCommandResult.builder().status(false).build();
        } else {
            createExam.saveExam(exam);
        }
        return CreateExamCommandResult.builder().status(true).build();
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public UpdateExamCommandResult updateExam(UpdateExamCommand updateExamCommand) {
        Exam exam = Exam.builder()
                .id(updateExamCommand.getId())
                .studentId(updateExamCommand.getStudentId())
                .subjectId(updateExamCommand.getSubjectId())
                .examDate(updateExamCommand.getExamDate())
                .score(updateExamCommand.getScore())
                .build();
        if (updateExamCommand.getScore() > 10 || updateExamCommand.getScore() < 0) {
            return UpdateExamCommandResult.builder().status(false).build();
        } else if (updateExamCommand.getExamDate().after(Date.from(Instant.now()))) {
            return UpdateExamCommandResult.builder().status(false).build();
        } else {
            updateExam.updateExam(exam);
        }
        return UpdateExamCommandResult.builder().status(true).build();
    }

    @Override
    public DeleteExamCommandResult deleteExam(Long id) {
        deleteExam.deleteExam(id);
        return DeleteExamCommandResult.builder().status(true).build();
    }

    @Override
    public List<ExamJpaEntity> sortExamByDateDesc() {
        return sortExam.sortExamByDateDesc();
    }

    @Override
    public List<ExamJpaEntity> sortExamByDateAsc() {
        return sortExam.sortExamByDateAsc();
    }

    @Override
    public List<ExamJpaEntity> sortExamByScoreDesc() {
        return sortExam.sortExamByScoreDesc();
    }

    @Override
    public List<ExamJpaEntity> sortExamByScoreAsc() {
        return sortExam.sortExamByScoreAsc();
    }

    @Override
    public List<ExamJpaEntity> sortExamByStudentIdDesc() {
        return sortExam.sortExamByStudentIdDesc();
    }

    @Override
    public List<ExamJpaEntity> sortExamByStudentIdAsc() {
        return sortExam.sortExamByStudentIdAsc();
    }

    @Override
    public List<ExamJpaEntity> sortExamBySubjectIdDesc() {
        return sortExam.sortExamBySubjectIdDesc();
    }

    @Override
    public List<ExamJpaEntity> sortExamBySubjectIdAsc() {
        return sortExam.sortExamBySubjectIdAsc();
    }

    @Override
    public List<Exam> searchExamByStudentId(Long studentId) {
        return searchExam.searchExamByStudentId(studentId);
    }

    @Override
    public List<Exam> searchExamBySubjectId(Long subjectId) {
        return searchExam.searchExamBySubjectId(subjectId);
    }

    @Override
    public List<Exam> searchExamByScore(int score) {
        return searchExam.searchExamByScore(score);
    }

    @Override
    public List<Exam> searchExamByDate(Date examDate) {
        return searchExam.searchExamByDate(examDate);
    }
}
