package com.example.studentcleanarch.application.service;

import com.example.studentcleanarch.application.port.in.teacher.*;
import com.example.studentcleanarch.application.port.out.teacher.CreateTeacher;
import com.example.studentcleanarch.application.port.out.teacher.UpdateTeacher;
import com.example.studentcleanarch.common.UseCase;
import com.example.studentcleanarch.domain.Teacher;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
public class TeacherService implements CreateTeacherUseCase, UpdateTeacherUseCase {

    private final CreateTeacher createTeacher;
    private final UpdateTeacher updateTeacher;

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public CreateTeacherCommandResult createTeacher(CreateTeacherCommand createTeacherCommand) {
        Teacher teacher = Teacher.builder()
                .teacherId(createTeacherCommand.getTeacherId())
                .teacherFirstName(createTeacherCommand.getTeacherFirstName())
                .teacherLastName(createTeacherCommand.getTeacherLastName())
                .joinDate(createTeacherCommand.getJoinDate())
                .gender(createTeacherCommand.getGender())
                .cic(createTeacherCommand.getCic())
                .issuePlace(createTeacherCommand.getIssuePlace())
                .issueDate(createTeacherCommand.getIssueDate())
                .expiredDate(createTeacherCommand.getExpiredDate())
                .birthDate(createTeacherCommand.getBirthDate())
                .nationality(createTeacherCommand.getNationality())
                .address(createTeacherCommand.getAddress())
                .active(createTeacherCommand.getActive())
                .build();
        if (createTeacherCommand.getExpiredDate().before(createTeacherCommand.getIssueDate())) {
            CreateTeacherCommandResult.builder().status(false).build();
        } else if (createTeacherCommand.getBirthDate().after(createTeacherCommand.getExpiredDate())) {
            CreateTeacherCommandResult.builder().status(false).build();
        }
        createTeacher.saveTeacher(teacher);
        return CreateTeacherCommandResult.builder().status(true).build();
    }

    @Override
    public UpdateTeacherCommandResult updateTeacher(UpdateTeacherCommand updateTeacherCommand) {
        Teacher teacher = Teacher.builder()
                .id(updateTeacherCommand.getId())
                .teacherId(updateTeacherCommand.getTeacherId())
                .teacherFirstName(updateTeacherCommand.getTeacherFirstName())
                .teacherLastName(updateTeacherCommand.getTeacherLastName())
                .joinDate(updateTeacherCommand.getJoinDate())
                .gender(updateTeacherCommand.getGender())
                .cic(updateTeacherCommand.getCic())
                .issuePlace(updateTeacherCommand.getIssuePlace())
                .issueDate(updateTeacherCommand.getIssueDate())
                .expiredDate(updateTeacherCommand.getExpiredDate())
                .birthDate(updateTeacherCommand.getBirthDate())
                .nationality(updateTeacherCommand.getNationality())
                .address(updateTeacherCommand.getAddress())
                .active(updateTeacherCommand.getActive())
                .build();
        updateTeacher.updateTeacher(teacher);
        return UpdateTeacherCommandResult.builder().status(true).build();
    }
}