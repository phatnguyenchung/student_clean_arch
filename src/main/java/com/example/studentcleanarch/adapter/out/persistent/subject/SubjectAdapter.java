package com.example.studentcleanarch.adapter.out.persistent.subject;

import com.example.studentcleanarch.application.port.out.subject.*;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.common.TimoException;
import com.example.studentcleanarch.domain.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
@Service
public class SubjectAdapter implements CreateSubject, UpdateSubject, DeleteSubject, GetSubject, SearchSubject, SortSubject {

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
    public void deleteSubject(Subject subject) {
        try {
            Optional<SubjectJpaEntity> subjectJpaEntity = subjectJpaRepository.findById(subject.getId());
            subjectJpaEntity.ifPresent(record -> {
                SubjectMapper.mapToExistedJpaEntity(subject, record);
                subjectJpaRepository.delete(record);
            });
        } catch (Exception e) {
            throw new TimoException(500, "Subject is not exist!");
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
                .orElseThrow(() -> new TimoException(500, "Subject not found id:" + id));
    }

    @Override
    public List<Subject> searchSubject(String subjectName) {
        try {
            List<SubjectJpaEntity> subjectJpaEntityList = subjectJpaRepository.findBySubjectName(subjectName);
            for (SubjectJpaEntity entity : subjectJpaEntityList) {
                System.out.println(entity.getSubjectId());
            }
            return subjectJpaRepository.findBySubjectName(subjectName).stream()
                    .map(SubjectMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Student could not found subject name:" + subjectName);
        }
    }

    @Override
    public List<Subject> searchSubjectByStartDate(Date startDate) {
        try {
            List<SubjectJpaEntity> subjectJpaEntityList = subjectJpaRepository.findByStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(startDate)));
            for (SubjectJpaEntity entity : subjectJpaEntityList) {
                System.out.println(entity.getSubjectId());
            }
            return subjectJpaRepository.findByStartDate(startDate).stream()
                    .map(SubjectMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Subject could not found by start date:" + startDate);
        }
    }

    @Override
    public List<SubjectJpaEntity> sortSubjectNameDesc() {
        return subjectJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "subjectName"));
    }

    @Override
    public List<SubjectJpaEntity> sortSubjectNameAsc() {
        return subjectJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "subjectName"));
    }

    @Override
    public List<SubjectJpaEntity> sortIdDesc() {
        return subjectJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public List<SubjectJpaEntity> sortIdAsc() {
        return subjectJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "id"));
    }

    @Override
    public List<SubjectJpaEntity> sortStartDateDesc() {
        return subjectJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "startDate"));
    }

    @Override
    public List<SubjectJpaEntity> sortStartDateAsc() {
        return subjectJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "startDate"));
    }

    @Override
    public List<SubjectJpaEntity> sortEndDateDesc() {
        return subjectJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "endDate"));
    }

    @Override
    public List<SubjectJpaEntity> sortEndDateAsc() {
        return subjectJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "endDate"));
    }
}
