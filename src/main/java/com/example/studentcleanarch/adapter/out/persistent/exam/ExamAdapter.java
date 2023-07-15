package com.example.studentcleanarch.adapter.out.persistent.exam;

import com.example.studentcleanarch.application.port.out.exam.CreateExam;
import com.example.studentcleanarch.application.port.out.exam.UpdateExam;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.domain.Exam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
@Service
public class ExamAdapter implements CreateExam, UpdateExam {

    private final ExamJpaRepository examJpaRepository;

    @Override
    public Exam saveExam(Exam exam) {
        ExamJpaEntity examJpaEntity = examJpaRepository.save(ExamMapper.mapToJpaEntity(exam));
        return ExamMapper.mapToDomainEntity(examJpaEntity);
    }

    @Override
    public void updateExam(Exam exam) {
        Optional<ExamJpaEntity> entity = examJpaRepository.findById(exam.getId());
        entity.ifPresent(record -> {
            ExamMapper.mapToExistedJpaEntity(exam, record);
            examJpaRepository.save(record);
        });
    }
}
