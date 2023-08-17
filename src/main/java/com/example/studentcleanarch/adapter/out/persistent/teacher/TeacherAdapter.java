package com.example.studentcleanarch.adapter.out.persistent.teacher;


import com.example.studentcleanarch.application.port.out.teacher.CreateTeacher;
import com.example.studentcleanarch.application.port.out.teacher.DeleteTeacher;
import com.example.studentcleanarch.application.port.out.teacher.GetTeacher;
import com.example.studentcleanarch.application.port.out.teacher.UpdateTeacher;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.common.TimoException;
import com.example.studentcleanarch.domain.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
@Service
public class TeacherAdapter implements CreateTeacher, UpdateTeacher, DeleteTeacher, GetTeacher {

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
}
