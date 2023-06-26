package com.example.studentcleanarch.application.service;

import com.example.studentcleanarch.application.port.in.CreateStudentCommand;
import com.example.studentcleanarch.application.port.in.CreateStudentCommandResult;
import com.example.studentcleanarch.application.port.in.CreateStudentUseCase;
import com.example.studentcleanarch.application.port.out.CreateStudent;
import com.example.studentcleanarch.domain.Student;
import lombok.AllArgsConstructor;

import javax.transaction.Transactional;


@AllArgsConstructor
public class StudentService implements CreateStudentUseCase {
    private final CreateStudent createStudent;
    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public CreateStudentCommandResult createStudent(CreateStudentCommand createStudentCommand) {
        Student student = Student.builder()
                .studentName(createStudentCommand.getStudentName())
                .className(createStudentCommand.getClassName())
                .gender(createStudentCommand.getGender())
                .birthDate(createStudentCommand.getBirthDate())
                .address(createStudentCommand.getAddress())
                .phoneNumber(createStudentCommand.getPhoneNumber())
                .studentParent(createStudentCommand.getStudentParent())
                .studentRelation(createStudentCommand.getStudentRelation())
                .jobTitle(createStudentCommand.getJobTitle())
                .birthParent(createStudentCommand.getBirthParent())
                .phoneNumberParent(createStudentCommand.getPhoneNumberParent())
                .build();
        createStudent.saveStudent(student);
        return CreateStudentCommandResult.builder().result(true).build();
    }
}
