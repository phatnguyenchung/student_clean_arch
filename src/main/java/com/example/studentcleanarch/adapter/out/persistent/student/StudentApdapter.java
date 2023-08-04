package com.example.studentcleanarch.adapter.out.persistent.student;

import com.example.studentcleanarch.application.port.out.student.*;
import com.example.studentcleanarch.common.PersistenceAdapter;
import com.example.studentcleanarch.common.TimoException;
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
            throw new TimoException(500, "Cannot get student list");
        }
    }

    @Override
    public Student getStudentById(Long id) {
        return studentJpaRepository.findById(id)
                .map(StudentMapper::mapToDomainEntity)
                .orElseThrow(() -> new TimoException(500, "Student not found id:" + id));
    }

    @Override
    public void deleteStudent(Student student) {
        Optional<StudentJpaEntity> entity = studentJpaRepository.findById(student.getId());
        entity.ifPresent(record -> {
            StudentMapper.mapToExistedJpaEntity(student, record);
            studentJpaRepository.delete(record);
        });
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
            throw new TimoException(500, "Student could not found last name:" + studentLastName);
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
            throw new TimoException(500, "Student could not found phone number:" + phoneNumber);
        }
    }

    @Override
    public List<Student> searchStudentByCIC(String CIC) {
        try {
            List<StudentJpaEntity> studentJpaEntityList = studentJpaRepository.findByCIC(CIC);
            for (StudentJpaEntity entity : studentJpaEntityList) {
                System.out.println(entity.getStudentId());
            }
            return studentJpaRepository.findByCIC(CIC).stream()
                    .map(StudentMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Student could not found CIC:" + CIC);
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
            throw new TimoException(500, "Student could not found class name:" + className);
        }
    }

    @Override
    public List<Student> searchStudentByParentPhoneNumber(Long parentPhoneNumber) {
        try {
            List<StudentJpaEntity> studentJpaEntityList = studentJpaRepository.findByParentPhoneNumber(parentPhoneNumber);
            for (StudentJpaEntity entity : studentJpaEntityList) {
                System.out.println(entity.getStudentId());
            }
            return studentJpaRepository.findByParentPhoneNumber(parentPhoneNumber).stream()
                    .map(StudentMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Student could not found parent phone number:" + parentPhoneNumber);
        }
    }

    @Override
    public List<Student> searchStudentByStudentParent(String studentParent) {
        try {
            List<StudentJpaEntity> studentJpaEntityList = studentJpaRepository.findByStudentParent(studentParent);
            for (StudentJpaEntity entity : studentJpaEntityList) {
                System.out.println(entity.getStudentId());
            }
            return studentJpaRepository.findByStudentParent(studentParent).stream()
                    .map(StudentMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Student could not found student parent:" + studentParent);
        }
    }

    @Override
    public List<Student> searchStudentByJobTitle(String jobTitle) {
        try {
            List<StudentJpaEntity> studentJpaEntityList = studentJpaRepository.findByJobTitle(jobTitle);
            for (StudentJpaEntity entity : studentJpaEntityList) {
                System.out.println(entity.getStudentId());
            }
            return studentJpaRepository.findByJobTitle(jobTitle).stream()
                    .map(StudentMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Student could not found job title:" + jobTitle);
        }
    }

    @Override
    public List<Student> searchStudentByStudentId(Long studentId) {
        try {
            List<StudentJpaEntity> studentJpaEntityList = studentJpaRepository.findByStudentId(studentId);
            for (StudentJpaEntity entity : studentJpaEntityList) {
                System.out.println(entity.getStudentId());
            }
            return studentJpaRepository.findByStudentId(studentId).stream()
                    .map(StudentMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Student could not found student id:" + studentId);
        }
    }

    @Override
    public List<Student> searchStudentByNationality(String nationality) {
        try {
            List<StudentJpaEntity> studentJpaEntityList = studentJpaRepository.findByNationality(nationality);
            for (StudentJpaEntity entity : studentJpaEntityList) {
                System.out.println(entity.getStudentId());
            }
            return studentJpaRepository.findByNationality(nationality).stream()
                    .map(StudentMapper::mapToDomainEntity)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new TimoException(500, "Student could not found nationality:" + nationality);
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

    @Override
    public List<StudentJpaEntity> sortStudentByIdDesc() {
        return studentJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentByIdAsc() {
        return studentJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "id"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentByCICDesc() {
        return studentJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "cic"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentByCICAsc() {
        return studentJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "cic"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentByClassNameDesc() {
        return studentJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "className"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentByClassNameAsc() {
        return studentJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "className"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentByStudentIdDesc() {
        return studentJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "studentId"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentByStudentIdAsc() {
        return studentJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "studentId"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentByAdmissionDateDesc() {
        return studentJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "admissionDate"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentByAdmissionDateAsc() {
        return studentJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "admissionDate"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentByCreatedDateDesc() {
        return studentJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentByCreatedDateAsc() {
        return studentJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "createdDate"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentByJobTitleDesc() {
        return studentJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "jobTitle"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentByJobTitleAsc() {
        return studentJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "jobTitle"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentFirstNameDesc() {
        return studentJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "studentFirstName"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentFirstNameAsc() {
        return studentJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "studentFirstName"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentByNationalityDesc() {
        return studentJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "nationality"));
    }

    @Override
    public List<StudentJpaEntity> sortStudentByNationalityAsc() {
        return studentJpaRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "nationality"));
    }
}
