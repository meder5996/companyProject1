package com.companyproject1.mapper.edit;

import com.companyproject1.dto.request.TeacherRequest;
import com.companyproject1.entity.Teacher;
import com.companyproject1.repository.CourseRepository;
import com.companyproject1.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class TeacherEdit {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public Teacher create(TeacherRequest teacherRequest, Long id) {
        if (teacherRequest == null) {
            return null;
        }
            Teacher teacher = new Teacher();
            List<Teacher> teacherList = teacherRepository.findAll();
            for (Teacher t : teacherList) {
                if (!Objects.equals(t.getCourse().getId(), id)) {
                    teacher.setFirstName(teacherRequest.getFirstName());
                    teacher.setEmail(teacherRequest.getEmail());
                    teacher.setLastName(teacherRequest.getLastName());
                    teacher.setCourse(courseRepository.findById(id).get());
                }
            }
            return teacher;
    }

    public void update(Teacher teacher, TeacherRequest teacherRequest) {
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setEmail(teacherRequest.getEmail());
        teacher.setLastName(teacherRequest.getLastName());
    }
}
