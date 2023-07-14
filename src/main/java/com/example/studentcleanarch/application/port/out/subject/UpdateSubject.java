package com.example.studentcleanarch.application.port.out.subject;

import com.example.studentcleanarch.domain.Subject;
import org.springframework.stereotype.Component;

@Component
public interface UpdateSubject {
    void updateSubject(Subject subject);
}
