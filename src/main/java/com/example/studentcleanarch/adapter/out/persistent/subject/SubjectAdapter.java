package com.example.studentcleanarch.adapter.out.persistent.subject;

import com.example.studentcleanarch.application.port.out.subject.CreateSubject;
import com.example.studentcleanarch.application.port.out.subject.UpdateSubject;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.domain.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
@Service
public class SubjectAdapter implements CreateSubject, UpdateSubject {

    private final SubjectJpaRepository subjectJpaRepository;

    @Override
    public Subject saveSubject(Subject subject) {
        SubjectJpaEntity subjectJpaEntity = subjectJpaRepository.save(SubjectMapper.mapToJpaEntity(subject));
        return SubjectMapper.mapToDomainEntity(subjectJpaEntity);
    }

    @Override
    public void updateSubject(Subject subject) {
        Optional<SubjectJpaEntity> subjectJpaEntity = subjectJpaRepository.findById(subject.getId());
        subjectJpaEntity.ifPresent(record -> {
            SubjectMapper.mapToExistedJpaEntity(subject, record);
            subjectJpaRepository.save(record);
        });
    }
}
