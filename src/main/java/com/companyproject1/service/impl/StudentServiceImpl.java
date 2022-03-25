package com.companyproject1.service.impl;

import com.companyproject1.dto.request.StudentRequest;
import com.companyproject1.dto.response.StudentResponse;
import com.companyproject1.entity.Student;
import com.companyproject1.mapper.edit.StudentEdit;
import com.companyproject1.mapper.view.StudentView;
import com.companyproject1.repository.StudentRepository;
import com.companyproject1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentEdit studentEdit;
    private final StudentView studentView;
    private final StudentRepository studentRepository;

    @Override
    public StudentResponse save(StudentRequest studentRequest, Long id) {
        return studentView.getStudent(studentRepository.save(studentEdit.create(studentRequest, id)));
    }

    @Override
    public List<StudentResponse> getAllStudent() {
        List<Student> responseList = studentRepository.findAll();
        return studentView.getStudentResponseList(responseList);
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id).get();
        return studentView.getStudent(student);
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        Student student = studentRepository.findById(id).get();
        studentEdit.update(student,studentRequest);
        Student student1 = studentRepository.findById(id).get();
        return studentView.getStudent(student1);
    }

    @Override
    public List<StudentResponse> deleteStudent(Long id) {
        studentRepository.deleteById(id);
        List<Student> studentList = studentRepository.findAll();
        return studentView.getStudentResponseList(studentList);
    }

    @Override
    public List<StudentResponse> deleteAllStudent() {
        studentRepository.deleteAll();
        List<Student> studentList = studentRepository.findAll();
        return studentView.getStudentResponseList(studentList);
    }
}
