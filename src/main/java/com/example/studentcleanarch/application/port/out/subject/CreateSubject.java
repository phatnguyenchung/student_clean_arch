package com.example.studentcleanarch.application.port.out.subject;

import com.example.studentcleanarch.domain.Subject;

public interface CreateSubject {
    Subject saveSubject(Subject subject);
}
