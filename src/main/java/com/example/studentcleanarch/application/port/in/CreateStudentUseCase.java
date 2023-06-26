package com.example.studentcleanarch.application.port.in;

public interface CreateStudentUseCase {
    CreateStudentCommandResult createStudent(CreateStudentCommand createStudentCommand);
}
