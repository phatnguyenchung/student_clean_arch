package com.example.studentcleanarch.adapter.out.persistent.teacher;


import com.example.studentcleanarch.application.port.out.teacher.CreateTeacher;
import com.example.studentcleanarch.application.port.out.teacher.UpdateTeacher;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.domain.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
@Service
public class TeacherAdapter implements CreateTeacher, UpdateTeacher {

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
}
