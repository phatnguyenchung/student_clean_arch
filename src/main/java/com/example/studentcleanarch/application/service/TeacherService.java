package com.example.studentcleanarch.application.service;

import com.example.studentcleanarch.application.port.in.teacher.CreateTeacherCommand;
import com.example.studentcleanarch.application.port.in.teacher.CreateTeacherCommandResult;
import com.example.studentcleanarch.application.port.in.teacher.CreateTeacherUseCase;
import com.example.studentcleanarch.application.port.out.teacher.CreateTeacher;
import com.example.studentcleanarch.common.UseCase;
import com.example.studentcleanarch.domain.Teacher;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@UseCase
@RequiredArgsConstructor
public class TeacherService implements CreateTeacherUseCase {

    private final CreateTeacher createTeacher;

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
}
