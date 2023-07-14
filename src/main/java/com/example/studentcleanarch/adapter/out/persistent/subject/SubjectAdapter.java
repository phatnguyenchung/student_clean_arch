package com.example.studentcleanarch.adapter.out.persistent.subject;

import com.example.studentcleanarch.application.port.out.subject.CreateSubject;
import com.example.studentcleanarch.application.port.out.subject.DeleteSubject;
import com.example.studentcleanarch.application.port.out.subject.GetSubject;
import com.example.studentcleanarch.application.port.out.subject.UpdateSubject;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.common.TimoException;
import com.example.studentcleanarch.domain.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
@Service
public class SubjectAdapter implements CreateSubject, UpdateSubject, DeleteSubject, GetSubject {

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

    @Override
    public void deleteSubject(Long id) {
        boolean existById = subjectJpaRepository.existsById(id);
        if (!existById) {
            subjectJpaRepository.findById(id)
                    .map(SubjectMapper::mapToDomainEntity)
                    .orElseThrow(() -> new TimoException(404, "Subject not found id:" + id));
        } else {
            subjectJpaRepository.deleteById(id);
        }
    }

    @Override
    public List<Subject> getAllSubject() {
        try {
            List<SubjectJpaEntity> subjectJpaEntityList = subjectJpaRepository.findAll();
            for (SubjectJpaEntity entity : subjectJpaEntityList) {
                System.out.println(entity.getSubjectId());
            }
            return subjectJpaRepository.findAll().stream()
                    .map(SubjectMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Cannot get subject list");
        }
    }

    @Override
    public Subject getSubjectById(Long id) {
        return subjectJpaRepository.findById(id)
                .map(SubjectMapper::mapToDomainEntity)
                .orElseThrow(() -> new TimoException(404, "Subject not found id:" + id));
    }
}
