package com.example.studentcleanarch.adapter.out.persistent.student;

import com.example.studentcleanarch.application.port.out.CreateStudent;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@PersistenceAdapter
@RequiredArgsConstructor
@Service
public class StudentApdapter implements CreateStudent {

    private final StudentJpaRepository studentJpaRepository;

    @Override
    public Student saveStudent(Student student) {
        StudentJpaEntity studentJpaEntity = studentJpaRepository.save(StudentMapper.mapToJpaEntity(student));
        return StudentMapper.mapToDomainEntity(studentJpaEntity);
    }
}
