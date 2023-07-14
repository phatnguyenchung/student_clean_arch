package com.example.studentcleanarch.application.port.out.subject;

import com.example.studentcleanarch.domain.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchSubject {

    List<Subject> searchSubject(String subjectName);
}
