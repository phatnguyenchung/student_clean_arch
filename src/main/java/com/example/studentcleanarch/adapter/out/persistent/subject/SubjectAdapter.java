package com.example.studentcleanarch.adapter.out.persistent.subject;

import com.example.studentcleanarch.application.port.out.subject.CreateSubject;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.domain.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@PersistenceAdapter
@RequiredArgsConstructor
@Service
public class SubjectAdapter implements CreateSubject {

    private final SubjectJpaRepository subjectJpaRepository;

    @Override
    public Subject saveSubject(Subject subject) {
        SubjectJpaEntity subjectJpaEntity = subjectJpaRepository.save(SubjectMapper.mapToJpaEntity(subject));
        return SubjectMapper.mapToDomainEntity(subjectJpaEntity);
    }
}
