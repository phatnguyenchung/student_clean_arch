package com.example.studentcleanarch.application.port.in.student;

public interface DeleteStudentUseCase {

    DeleteStudentCommandResult deleteStudent(DeleteStudentCommand deleteStudentCommand);
}
