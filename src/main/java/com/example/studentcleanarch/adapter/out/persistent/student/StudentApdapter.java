package com.example.studentcleanarch.adapter.out.persistent.student;

import com.example.studentcleanarch.application.port.out.CreateStudent;
import com.example.studentcleanarch.application.port.out.GetStudent;
import com.example.studentcleanarch.application.port.out.UpdateStudent;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
@Service
public class StudentApdapter implements CreateStudent, UpdateStudent, GetStudent {

    private final StudentJpaRepository studentJpaRepository;

    @Override
    public Student saveStudent(Student student) {
        StudentJpaEntity studentJpaEntity = studentJpaRepository.save(StudentMapper.mapToJpaEntity(student));
        return StudentMapper.mapToDomainEntity(studentJpaEntity);
    }

    @Override
    public void updateStudent(Student student) {
        Optional<StudentJpaEntity> entity = studentJpaRepository.findById(student.getId());
        entity.ifPresent(record -> {
            StudentMapper.mapToExistedJpaEntity(student, record);
            studentJpaRepository.save(record);
        });
    }

    @Override
    public List<Student> getAllStudent() {
        try{
            List<StudentJpaEntity> studentJpaEntityList = studentJpaRepository.findAll();
            for(StudentJpaEntity entity : studentJpaEntityList){
                System.out.println(entity.getStudentId());
            }
            return studentJpaRepository.findAll().stream()
                    .map(StudentMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw new RuntimeException(new Exception());
        }
    }
}
