package com.example.studentcleanarch.adapter.out.persistent.teacher;


import com.example.studentcleanarch.application.port.out.teacher.*;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.common.TimoException;
import com.example.studentcleanarch.domain.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
@Service
public class TeacherAdapter implements CreateTeacher, UpdateTeacher, DeleteTeacher, GetTeacher, SearchTeacher, SortTeacher {

    private final TeacherJpaRepository repository;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        TeacherJpaEntity teacherJpaEntity = repository.save(TeacherMapper.mapToJpaEntity(teacher));
        return TeacherMapper.mapToDomainEntity(teacherJpaEntity);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        Optional<TeacherJpaEntity> teacherJpaEntity = repository.findById(teacher.getId());
        teacherJpaEntity.ifPresent(record -> {
            TeacherMapper.mapToExistedJpaEntity(teacher, record);
            repository.save(record);
        });
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        try {
            Optional<TeacherJpaEntity> teacherJpaEntity = repository.findById(teacher.getId());
            teacherJpaEntity.ifPresent(record -> {
                TeacherMapper.mapToExistedJpaEntity(teacher, record);
                repository.delete(record);
            });
        } catch (Exception e) {
            throw new TimoException(500, "Teacher is not exist!");
        }
    }

    @Override
    public List<Teacher> getAllTeacher() {
        try {
            List<TeacherJpaEntity> teacherJpaEntityList = repository.findAll();
            for (TeacherJpaEntity entity : teacherJpaEntityList) {
                System.out.println(entity.getTeacherId());
            }
            return repository.findAll().stream()
                    .map(TeacherMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Cannot get teacher list");
        }
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return repository.findById(id)
                .map(TeacherMapper::mapToDomainEntity)
                .orElseThrow(() -> new TimoException(500, "Teacher not found id:" + id));
    }

    @Override
    public List<Teacher> searchTeacherByLastName(String teacherLastName) {
        try {
            List<TeacherJpaEntity> teacherJpaEntityList = repository.searchTeacherByLastName(teacherLastName);
            for (TeacherJpaEntity entity : teacherJpaEntityList) {
                System.out.println(entity.getTeacherId());
            }
            return repository.searchTeacherByLastName(teacherLastName).stream()
                    .map(TeacherMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Teacher could not found last name:" + teacherLastName);
        }
    }

    @Override
    public List<Teacher> searchTeacherByCIC(String CIC) {
        try {
            List<TeacherJpaEntity> teacherJpaEntityList = repository.searchTeacherByCIC(CIC);
            for (TeacherJpaEntity entity : teacherJpaEntityList) {
                System.out.println(entity.getTeacherId());
            }
            return repository.searchTeacherByCIC(CIC).stream()
                    .map(TeacherMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Teacher could not found CIC:" + CIC);
        }
    }

    @Override
    public List<Teacher> searchTeacherByAddress(String address) {
        try {
            List<TeacherJpaEntity> teacherJpaEntityList = repository.searchTeacherByAddress(address);
            for (TeacherJpaEntity entity : teacherJpaEntityList) {
                System.out.println(entity.getTeacherId());
            }
            return repository.searchTeacherByAddress(address).stream()
                    .map(TeacherMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Teacher could not found address:" + address);
        }
    }

    @Override
    public List<Teacher> searchTeacherByPhoneNumber(String phoneNumber) {
        try {
            List<TeacherJpaEntity> teacherJpaEntityList = repository.searchTeacherByPhoneNumber(phoneNumber);
            for (TeacherJpaEntity entity : teacherJpaEntityList) {
                System.out.println(entity.getTeacherId());
            }
            return repository.searchTeacherByPhoneNumber(phoneNumber).stream()
                    .map(TeacherMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Teacher could not found phone number:" + phoneNumber);
        }
    }

    @Override
    public List<TeacherJpaEntity> sortTeacherByIdAsc() {
        return repository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "id"));
    }

    @Override
    public List<TeacherJpaEntity> sortTeacherByIdDesc() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public List<TeacherJpaEntity> sortTeacherByTeacherIdAsc() {
        return repository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "teacherId"));
    }

    @Override
    public List<TeacherJpaEntity> sortTeacherByTeacherIdDesc() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "teacherId"));
    }

    @Override
    public List<TeacherJpaEntity> sortTeacherByTeacherLastNameAsc() {
        return repository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "teacherLastName"));
    }

    @Override
    public List<TeacherJpaEntity> sortTeacherByTeacherLastNameDesc() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "teacherLastName"));
    }

    @Override
    public List<TeacherJpaEntity> sortTeacherByTeacherFirstNameAsc() {
        return repository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "teacherFirstName"));
    }

    @Override
    public List<TeacherJpaEntity> sortTeacherByTeacherFirstNameDesc() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "teacherFirstName"));
    }
}
