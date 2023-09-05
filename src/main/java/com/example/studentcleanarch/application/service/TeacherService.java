package com.example.studentcleanarch.application.service;

import com.example.studentcleanarch.adapter.out.persistent.teacher.TeacherJpaEntity;
import com.example.studentcleanarch.application.port.in.teacher.*;
import com.example.studentcleanarch.application.port.out.teacher.*;
import com.example.studentcleanarch.common.UseCase;
import com.example.studentcleanarch.domain.Teacher;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@UseCase
@RequiredArgsConstructor
public class TeacherService implements CreateTeacherUseCase, UpdateTeacherUseCase, DeleteTeacherUseCase, GetTeacherUseCase, SearchTeacherUseCase, SortTeacherUseCase {

    private final CreateTeacher createTeacher;
    private final UpdateTeacher updateTeacher;
    private final DeleteTeacher deleteTeacher;
    private final GetTeacher getTeacher;
    private final SearchTeacher searchTeacher;
    private final SortTeacher sortTeacher;

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
                .phoneNumber(createTeacherCommand.getPhoneNumber())
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
                .phoneNumber(updateTeacherCommand.getPhoneNumber())
                .active(updateTeacherCommand.getActive())
                .build();
        updateTeacher.updateTeacher(teacher);
        return UpdateTeacherCommandResult.builder().status(true).build();
    }

    @Override
    public DeleteTeacherCommandResult deleteTeacher(DeleteTeacherCommand deleteTeacherCommand) {
        Teacher teacher = Teacher.builder()
                .id(deleteTeacherCommand.getId())
                .build();
        deleteTeacher.deleteTeacher(teacher);
        return DeleteTeacherCommandResult.builder().status(true).build();
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return getTeacher.getAllTeacher();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return getTeacher.getTeacherById(id);
    }

    @Override
    public List<Teacher> searchTeacherByLastName(String teacherLastName) {
        return searchTeacher.searchTeacherByLastName(teacherLastName);
    }

    @Override
    public List<Teacher> searchTeacherByFirstName(String teacherFirstName) {
        return searchTeacher.searchTeacherByFirstName(teacherFirstName);
    }

    @Override
    public List<Teacher> searchTeacherByCIC(String CIC) {
        return searchTeacher.searchTeacherByCIC(CIC);
    }

    @Override
    public List<Teacher> searchTeacherByAddress(String address) {
        return searchTeacher.searchTeacherByAddress(address);
    }

    @Override
    public List<Teacher> searchTeacherByPhoneNumber(String phoneNumber) {
        return searchTeacher.searchTeacherByPhoneNumber(phoneNumber);
    }

    @Override
    public List<TeacherJpaEntity> sortTeacherByIdAsc() {
        return sortTeacher.sortTeacherByIdAsc();
    }

    @Override
    public List<TeacherJpaEntity> sortTeacherByIdDesc() {
        return sortTeacher.sortTeacherByIdDesc();
    }

    @Override
    public List<TeacherJpaEntity> sortTeacherByTeacherIdAsc() {
        return sortTeacher.sortTeacherByTeacherIdAsc();
    }

    @Override
    public List<TeacherJpaEntity> sortTeacherByTeacherIdDesc() {
        return sortTeacher.sortTeacherByTeacherIdDesc();
    }

    @Override
    public List<TeacherJpaEntity> sortTeacherByTeacherLastNameAsc() {
        return sortTeacher.sortTeacherByTeacherLastNameAsc();
    }

    @Override
    public List<TeacherJpaEntity> sortTeacherByTeacherLastNameDesc() {
        return sortTeacher.sortTeacherByTeacherLastNameDesc();
    }

    @Override
    public List<TeacherJpaEntity> sortTeacherByTeacherFirstNameAsc() {
        return sortTeacher.sortTeacherByTeacherFirstNameAsc();
    }

    @Override
    public List<TeacherJpaEntity> sortTeacherByTeacherFirstNameDesc() {
        return sortTeacher.sortTeacherByTeacherFirstNameDesc();
    }
}
