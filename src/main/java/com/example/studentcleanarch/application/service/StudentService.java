package com.example.studentcleanarch.application.service;

import com.example.studentcleanarch.adapter.out.persistent.student.StudentJpaEntity;
import com.example.studentcleanarch.application.port.in.*;
import com.example.studentcleanarch.application.port.out.*;
import com.example.studentcleanarch.common.UseCase;
import com.example.studentcleanarch.domain.Student;
import lombok.RequiredArgsConstructor;


import javax.transaction.Transactional;
import java.util.List;



@UseCase
@RequiredArgsConstructor
public class StudentService implements CreateStudentUseCase, UpdateStudentUseCase, GetStudentUseCase, DeleteStudentUseCase, SearchStudentUseCase, SortStudentUseCase {
    private final CreateStudent createStudent;
    private final UpdateStudent updateStudent;
    private final GetStudent getStudent;
    private final DeleteStudent deleteStudent;
    private final SearchStudent searchStudent;
    private final SortStudent sortStudent;
    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public CreateStudentCommandResult createStudent(CreateStudentCommand createStudentCommand) {
        Student student = Student.builder()
                .studentId(createStudentCommand.getStudentId())
                .studentName(createStudentCommand.getStudentName())
                .className(createStudentCommand.getClassName())
                .gender(createStudentCommand.getGender())
                .idNumber(createStudentCommand.getIdNumber())
                .birthDate(createStudentCommand.getBirthDate())
                .address(createStudentCommand.getAddress())
                .phoneNumber(createStudentCommand.getPhoneNumber())
                .studentParent(createStudentCommand.getStudentParent())
                .studentRelation(createStudentCommand.getStudentRelation())
                .jobTitle(createStudentCommand.getJobTitle())
                .birthParent(createStudentCommand.getBirthParent())
                .phoneNumberParent(createStudentCommand.getPhoneNumberParent())
                .build();
        createStudent.saveStudent(student);
        return CreateStudentCommandResult.builder().result(true).build();
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public UpdateStudentCommandResult updateStudent(UpdateStudentCommand updateStudentCommand) {
        Student student = Student.builder()
                .id(updateStudentCommand.getId())
                .studentId(updateStudentCommand.getStudentId())
                .studentName(updateStudentCommand.getStudentName())
                .className(updateStudentCommand.getClassName())
                .gender(updateStudentCommand.getGender())
                .idNumber(updateStudentCommand.getIdNumber())
                .birthDate(updateStudentCommand.getBirthDate())
                .address(updateStudentCommand.getAddress())
                .phoneNumber(updateStudentCommand.getPhoneNumber())
                .studentParent(updateStudentCommand.getStudentParent())
                .jobTitle(updateStudentCommand.getJobTitle())
                .birthParent(updateStudentCommand.getBirthParent())
                .phoneNumberParent(updateStudentCommand.getPhoneNumberParent())
                .build();
        updateStudent.updateStudent(student);
        return UpdateStudentCommandResult.builder().status(true).build();
    }

    @Override
    public List<Student> getAllStudent() {
        return getStudent.getAllStudent();
    }

    @Override
    public Student getStudentById(Long id) {
        return getStudent.getStudentById(id);
    }

    @Override
    public DeleteStudentCommandResult deleteStudent(Long id) {
        deleteStudent.deleteStudent(id);
        return DeleteStudentCommandResult.builder().status(true).build();
    }

    @Override
    public List<Student> searchStudentByStudentName(String studentName) {
        return searchStudent.searchStudentByName(studentName);
    }


    @Override
    public List<Student> searchStudentByPhoneNumber(Long phoneNumber) {
        return searchStudent.searchStudentByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Student> searchStudentByIdNumber(String idNumber) {
        return searchStudent.searchStudentByIdNumber(idNumber);
    }

    @Override
    public List<StudentJpaEntity> sortStudentOrderByDesc() {
        return sortStudent.sortStudentDesc();
    }

    @Override
    public List<StudentJpaEntity> sortStudentOrderByAsc() {
        return sortStudent.sortStudentAsc();
    }
}
