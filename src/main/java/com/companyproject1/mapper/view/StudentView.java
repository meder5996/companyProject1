package com.companyproject1.mapper.view;

import com.companyproject1.dto.response.StudentResponse;
import com.companyproject1.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentView {
    public StudentResponse getStudent(Student student) {
        if (student == null) {
            return null;
        } else {
            StudentResponse studentResponse = new StudentResponse();
            if (student.getId() != null) {
                studentResponse.setId(String.valueOf(student.getId()));
            }
            studentResponse.setFirstName(student.getFirstName());
            studentResponse.setEmail(student.getEmail());
            studentResponse.setLastName(student.getLastName());
            studentResponse.setStudyFormat(student.getStudyFormat());
            return studentResponse;
        }
    }

    public List<StudentResponse> getStudentResponseList(List<Student> studentList) {
        List<StudentResponse> responseList = new ArrayList<>();
        for (Student student : studentList) {
            responseList.add(getStudent(student));
        }
        return responseList;
    }
}
