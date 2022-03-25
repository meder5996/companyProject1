package com.companyproject1.service;

import com.companyproject1.dto.request.StudentRequest;
import com.companyproject1.dto.response.StudentResponse;
import com.companyproject1.entity.Student;

import java.util.List;

public interface StudentService {

    StudentResponse save(StudentRequest studentRequest, Long id);

    List<StudentResponse> getAllStudent();

    StudentResponse getStudentById(Long id);

    StudentResponse updateStudent(Long id, StudentRequest studentRequest);

    List<StudentResponse> deleteStudent(Long id);

    List<StudentResponse> deleteAllStudent();
}
