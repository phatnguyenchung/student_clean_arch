package com.example.studentcleanarch.application.port.in.teacher;

public interface DeleteTeacherUseCase {
    DeleteTeacherCommandResult deleteTeacher(DeleteTeacherCommand deleteTeacherCommand);
}
