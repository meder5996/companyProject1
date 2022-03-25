package com.companyproject1.mapper.edit;

import com.companyproject1.dto.request.StudentRequest;
import com.companyproject1.entity.Student;
import com.companyproject1.repository.GroupRepository;
import com.companyproject1.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentEdit {

    private final GroupRepository groupRepository;

    public Student create(StudentRequest studentRequest, Long id) {
        if (studentRequest == null) {
            return null;
        } else {
            Student student = new Student();
            student.setEmail(studentRequest.getEmail());
            student.setFirstName(studentRequest.getFirstName());
            student.setStudyFormat(studentRequest.getStudyFormat());
            student.setLastName(studentRequest.getLastName());
            student.setGroup(groupRepository.findById(id).get());
            return student;
        }
    }

    public void update(Student student, StudentRequest studentRequest) {
        student.setLastName(studentRequest.getLastName());
        student.setStudyFormat(studentRequest.getStudyFormat());
        student.setEmail(studentRequest.getEmail());
        student.setFirstName(studentRequest.getFirstName());
    }
}
