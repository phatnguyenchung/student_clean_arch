package com.example.studentcleanarch.application.port.in.subject;

import com.example.studentcleanarch.domain.Subject;

import java.util.List;

public interface SearchSubjectUseCase {

    List<Subject> searchSubject(String subject);
}
