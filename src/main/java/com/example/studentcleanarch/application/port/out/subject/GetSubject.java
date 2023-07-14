package com.example.studentcleanarch.application.port.out.subject;

import com.example.studentcleanarch.domain.Subject;

import java.util.List;

public interface GetSubject {
    List<Subject> getAllSubject();

    Subject getSubjectById(Long id);
}
