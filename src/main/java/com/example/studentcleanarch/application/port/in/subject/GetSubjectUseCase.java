package com.example.studentcleanarch.application.port.in.subject;

import com.example.studentcleanarch.domain.Subject;

import java.util.List;

public interface GetSubjectUseCase {
    List<Subject> getAllSubject();

    Subject getSubjectById(Long id);
}
