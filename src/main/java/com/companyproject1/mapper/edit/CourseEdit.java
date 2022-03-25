package com.companyproject1.mapper.edit;

import com.companyproject1.dto.request.CourseRequest;
import com.companyproject1.entity.Course;
import com.companyproject1.entity.Group;
import com.companyproject1.repository.CompanyRepository;
import com.companyproject1.repository.CourseRepository;
import com.companyproject1.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseEdit {

    private final CompanyRepository companyRepository;
    private final CourseRepository courseRepository;
    private final GroupRepository groupRepository;

    public Course create(CourseRequest courseRequest, Long id) {
        if (courseRequest == null) {
            return null;
        } else {
            Course course = new Course();
            course.setCourseName(courseRequest.getCourseName());
            course.setDuration(courseRequest.getDuration());
            course.setCompany(companyRepository.findById(id).get());
            List<Course> courseList = courseRepository.findAll();
            List<Group> groupList = groupRepository.findAll();
            for (Course course1 : courseList) {
                course1.setGroupList(groupList);
                for (Group group : groupList) {
                    group.setCourseList(courseList);
                }
            }
            return course;
        }
    }

    public void update(Course course, CourseRequest courseRequest) {
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
    }

}
