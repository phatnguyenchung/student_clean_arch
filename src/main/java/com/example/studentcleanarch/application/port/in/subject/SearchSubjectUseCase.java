package com.example.studentcleanarch.application.port.in.subject;

import com.example.studentcleanarch.domain.Subject;

import java.util.Date;
import java.util.List;

public interface SearchSubjectUseCase {

    List<Subject> searchSubject(String subject);

    List<Subject> searchSubjectByStartDate(Date startDate);
}
