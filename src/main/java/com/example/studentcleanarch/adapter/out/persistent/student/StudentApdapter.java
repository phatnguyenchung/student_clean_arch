package com.example.studentcleanarch.adapter.out.persistent.student;

import com.example.studentcleanarch.application.port.out.*;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
@Service
public class StudentApdapter implements CreateStudent, UpdateStudent, GetStudent, DeleteStudent, SearchStudent, SortStudent {

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
        try {
            List<StudentJpaEntity> studentJpaEntityList = studentJpaRepository.findAll();
            for (StudentJpaEntity entity : studentJpaEntityList) {
                System.out.println(entity.getStudentId());
            }
            return studentJpaRepository.findAll().stream()
                    .map(StudentMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(new Exception());
        }
    }

    @Override
    public Student getStudentById(long id) {
        return studentJpaRepository.findById(id)
                .map(StudentMapper::mapToDomainEntity)
                .orElseThrow();
    }

    @Override
    public void deleteStudent(Long id) {
        boolean existById = studentJpaRepository.existsById(id);
        if (!existById) {
            System.out.println("Student is not exist for given id");
        } else {
            studentJpaRepository.deleteById(id);
        }
    }

    @Override
    public List<Student> searchStudentByLastName(String studentLastName) {

        try {
            List<StudentJpaEntity> studentJpaEntityList = studentJpaRepository.findByStudentLastName(studentLastName);
            for (StudentJpaEntity entity : studentJpaEntityList) {
                System.out.println(entity.getStudentId());
            }
            return studentJpaRepository.findByStudentLastName(studentLastName).stream()
                    .map(StudentMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(new Exception());
        }
    }

    @Override
    public List<Student> searchStudentByPhoneNumber(Long phoneNumber) {
        try {
            List<StudentJpaEntity> studentJpaEntityList = studentJpaRepository.findByPhoneNumber(phoneNumber);
            for (StudentJpaEntity entity : studentJpaEntityList) {
                System.out.println(entity.getStudentId());
            }
            return studentJpaRepository.findByPhoneNumber(phoneNumber).stream()
                    .map(StudentMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(new Exception());
        }
    }

    @Override
    public List<Student> searchStudentByIdNumber(String idNumber) {
        try {
            List<StudentJpaEntity> studentJpaEntityList = studentJpaRepository.findByIdNumber(idNumber);
            for (StudentJpaEntity entity : studentJpaEntityList) {
                System.out.println(entity.getStudentId());
            }
            return studentJpaRepository.findByIdNumber(idNumber).stream()
                    .map(StudentMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(new Exception());
        }
    }

    @Override
    public List<Student> searchStudentByClassName(String className) {
        try {
            List<StudentJpaEntity> studentJpaEntityList = studentJpaRepository.findByClassName(className);
            for (StudentJpaEntity entity : studentJpaEntityList) {
                System.out.println(entity.getStudentId());
            }
            return studentJpaRepository.findByClassName(className).stream()
                    .map(StudentMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(new Exception());
        }
    }

    @Override
    public List<StudentJpaEntity> sortStudentLastNameDesc() {
        return studentJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "studentLastName"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentLastNameAsc() {
        return studentJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "studentLastName"));
    }
}
