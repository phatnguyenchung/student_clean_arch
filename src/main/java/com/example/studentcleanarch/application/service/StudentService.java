package com.example.studentcleanarch.application.service;

import com.example.studentcleanarch.application.port.in.CreateStudentCommand;
import com.example.studentcleanarch.application.port.in.CreateStudentCommandResult;
import com.example.studentcleanarch.application.port.in.CreateStudentUseCase;
import com.example.studentcleanarch.application.port.out.CreateStudent;
import com.example.studentcleanarch.common.UseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@UseCase
public class StudentService implements CreateStudentUseCase {
    private final CreateStudent createStudent;
    @Override
    public CreateStudentCommandResult createStudent(CreateStudentCommand createStudentCommand) {
        return null;
    }
}
