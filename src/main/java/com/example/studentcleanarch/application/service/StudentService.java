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
                .studentFirstName(createStudentCommand.getStudentFirstName())
                .studentLastName(createStudentCommand.getStudentLastName())
                .className(createStudentCommand.getClassName())
                .gender(createStudentCommand.getGender())
                .cic(createStudentCommand.getCIC())
                .birthDate(createStudentCommand.getBirthDate())
                .address(createStudentCommand.getAddress())
                .phoneNumber(createStudentCommand.getPhoneNumber())
                .studentParent(createStudentCommand.getStudentParent())
                .studentRelation(createStudentCommand.getStudentRelation())
                .jobTitle(createStudentCommand.getJobTitle())
                .birthParent(createStudentCommand.getBirthParent())
                .phoneNumberParent(createStudentCommand.getPhoneNumberParent())
                .admissionDate(createStudentCommand.getAdmissionDate())
                .active(createStudentCommand.getActive())
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
                .studentFirstName(updateStudentCommand.getStudentFirstName())
                .studentLastName(updateStudentCommand.getStudentLastName())
                .className(updateStudentCommand.getClassName())
                .gender(updateStudentCommand.getGender())
                .cic(updateStudentCommand.getCIC())
                .birthDate(updateStudentCommand.getBirthDate())
                .address(updateStudentCommand.getAddress())
                .phoneNumber(updateStudentCommand.getPhoneNumber())
                .studentParent(updateStudentCommand.getStudentParent())
                .studentRelation(updateStudentCommand.getStudentRelation())
                .jobTitle(updateStudentCommand.getJobTitle())
                .birthParent(updateStudentCommand.getBirthParent())
                .phoneNumberParent(updateStudentCommand.getPhoneNumberParent())
                .admissionDate(updateStudentCommand.getAdmissionDate())
                .active(updateStudentCommand.getActive())
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
    public List<Student> searchStudentByStudentLastName(String studentLastName) {
        return searchStudent.searchStudentByLastName(studentLastName);
    }


    @Override
    public List<Student> searchStudentByPhoneNumber(Long phoneNumber) {
        return searchStudent.searchStudentByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Student> searchStudentByCIC(String CIC) {
        return searchStudent.searchStudentByCIC(CIC);
    }

    @Override
    public List<Student> searchStudentByClassName(String className) {
        return searchStudent.searchStudentByClassName(className);
    }

    @Override
    public List<Student> searchStudentByParentPhoneNumber(Long parentPhoneNumber) {
        return searchStudent.searchStudentByParentPhoneNumber(parentPhoneNumber);
    }

    @Override
    public List<Student> searchStudentByStudentParent(String studentParent) {
        return searchStudent.searchStudentByStudentParent(studentParent);
    }

    @Override
    public List<Student> searchStudentByJobTitle(String jobTitle) {
        return searchStudent.searchStudentByJobTitle(jobTitle);
    }

    @Override
    public List<StudentJpaEntity> sortStudentLastNameOrderByDesc() {
        return sortStudent.sortStudentLastNameDesc();
    }

    @Override
    public List<StudentJpaEntity> sortStudentLastNameOrderByAsc() {
        return sortStudent.sortStudentLastNameAsc();
    }

    @Override
    public List<StudentJpaEntity> sortStudentByIdDesc() {
        return sortStudent.sortStudentByIdDesc();
    }

    @Override
    public List<StudentJpaEntity> sortStudentByIdAsc() {
        return sortStudent.sortStudentByIdAsc();
    }

    @Override
    public List<StudentJpaEntity> sortStudentByCICDesc() {
        return sortStudent.sortStudentByCICDesc();
    }

    @Override
    public List<StudentJpaEntity> sortStudentByCICAsc() {
        return sortStudent.sortStudentByCICAsc();
    }

    @Override
    public List<StudentJpaEntity> sortStudentByClassNameDesc() {
        return sortStudent.sortStudentByClassNameDesc();
    }

    @Override
    public List<StudentJpaEntity> sortStudentByClassNameAsc() {
        return sortStudent.sortStudentByClassNameAsc();
    }

    @Override
    public List<StudentJpaEntity> sortStudentByStudentIdDesc() {
        return sortStudent.sortStudentByStudentIdDesc();
    }

    @Override
    public List<StudentJpaEntity> sortStudentByStudentIdAsc() {
        return sortStudent.sortStudentByStudentIdAsc();
    }

    @Override
    public List<StudentJpaEntity> sortStudentByAdmissionDateDesc() {
        return sortStudent.sortStudentByAdmissionDateDesc();
    }

    @Override
    public List<StudentJpaEntity> sortStudentByAdmissionDateAsc() {
        return sortStudent.sortStudentByAdmissionDateAsc();
    }

    @Override
    public List<StudentJpaEntity> sortStudentByCreatedDateDesc() {
        return sortStudent.sortStudentByCreatedDateDesc();
    }

    @Override
    public List<StudentJpaEntity> sortStudentByCreatedDateAsc() {
        return sortStudent.sortStudentByCreatedDateAsc();
    }
}
