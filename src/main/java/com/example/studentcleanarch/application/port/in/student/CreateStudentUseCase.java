package com.example.studentcleanarch.application.port.in.student;

public interface CreateStudentUseCase {
    CreateStudentCommandResult createStudent(CreateStudentCommand createStudentCommand);
}
