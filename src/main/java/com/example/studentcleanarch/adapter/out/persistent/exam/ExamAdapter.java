package com.example.studentcleanarch.adapter.out.persistent.exam;

import com.example.studentcleanarch.application.port.out.exam.*;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.common.TimoException;
import com.example.studentcleanarch.domain.Exam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
@Service
public class ExamAdapter implements CreateExam, UpdateExam, DeleteExam, SortExam, SearchExam, GetExam {

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

    @Override
    public List<ExamJpaEntity> sortExamByDateDesc() {
        return examJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "examDate"));
    }

    @Override
    public List<ExamJpaEntity> sortExamByDateAsc() {
        return examJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "examDate"));
    }

    @Override
    public List<ExamJpaEntity> sortExamByScoreDesc() {
        return examJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "score"));
    }

    @Override
    public List<ExamJpaEntity> sortExamByScoreAsc() {
        return examJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "score"));
    }

    @Override
    public List<ExamJpaEntity> sortExamByStudentIdDesc() {
        return examJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "studentId"));
    }

    @Override
    public List<ExamJpaEntity> sortExamByStudentIdAsc() {
        return examJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "studentId"));
    }

    @Override
    public List<ExamJpaEntity> sortExamBySubjectIdDesc() {
        return examJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "subjectId"));
    }

    @Override
    public List<ExamJpaEntity> sortExamBySubjectIdAsc() {
        return examJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "subjectId"));
    }

    @Override
    public List<ExamJpaEntity> sortExamByIdAsc() {
        return examJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "id"));
    }

    @Override
    public List<ExamJpaEntity> sortExamByIdDesc() {
        return examJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public List<Exam> searchExamByStudentId(Long studentId) {
        try {
            List<ExamJpaEntity> examJpaEntityList = examJpaRepository.findByStudentId(studentId);
            for (ExamJpaEntity entity : examJpaEntityList) {
                System.out.println(entity.getSubjectId());
            }
            return examJpaRepository.findByStudentId(studentId).stream()
                    .map(ExamMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Exam could not found by student id:" + studentId);
        }
    }

    @Override
    public List<Exam> searchExamBySubjectId(Long subjectId) {
        try {
            List<ExamJpaEntity> examJpaEntityList = examJpaRepository.findBySubjectId(subjectId);
            for (ExamJpaEntity entity : examJpaEntityList) {
                System.out.println(entity.getSubjectId());
            }
            return examJpaRepository.findBySubjectId(subjectId).stream()
                    .map(ExamMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Exam could not found by subject id:" + subjectId);
        }
    }

    @Override
    public List<Exam> searchExamByScore(int score) {
        try {
            List<ExamJpaEntity> examJpaEntityList = examJpaRepository.findByScore(score);
            for (ExamJpaEntity entity : examJpaEntityList) {
                System.out.println(entity.getSubjectId());
            }
            return examJpaRepository.findByScore(score).stream()
                    .map(ExamMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Exam could not found by score:" + score);
        }
    }


    @Override
    public List<Exam> searchExamByDate(Date examDate) {
        try {
            List<ExamJpaEntity> examJpaEntityList = examJpaRepository.findByExamDate(examDate);
            for (ExamJpaEntity entity : examJpaEntityList) {
                System.out.println(entity.getSubjectId());
            }
            return examJpaRepository.findByExamDate(examDate).stream()
                    .map(ExamMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Exam could not found by exam date:" + examDate);
        }
    }

    @Override
    public List<Exam> getAllEaxam() {
        try {
            List<ExamJpaEntity> examJpaEntityList = examJpaRepository.findAll();
            for (ExamJpaEntity entity : examJpaEntityList) {
                System.out.println(entity.getId());
            }
            return examJpaRepository.findAll().stream()
                    .map(ExamMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Cannot get exam list");
        }
    }

    @Override
    public Exam getExamById(Long id) {
        return examJpaRepository.findById(id)
                .map(ExamMapper::mapToDomainEntity)
                .orElseThrow(() -> new TimoException(500, "Exam not found id:" + id));
    }

    @Override
    public void deleteExam(Exam exam) {
        try {
            Optional<ExamJpaEntity> entity = examJpaRepository.findById(exam.getId());
            entity.ifPresent(record -> {
                ExamMapper.mapToExistedJpaEntity(exam, record);
                examJpaRepository.delete(record);
            });
        } catch (Exception e) {
            throw new TimoException(500, "Exam is not exist!");
        }
    }
}
