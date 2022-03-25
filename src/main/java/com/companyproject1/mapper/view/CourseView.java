package com.companyproject1.mapper.view;

import com.companyproject1.dto.response.CourseResponse;
import com.companyproject1.entity.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseView {

    public CourseResponse getCourse(Course course) {
        if (course == null) {
            return null;
        } else {
            CourseResponse courseResponse = new CourseResponse();
            if (course.getId() != null) {
                courseResponse.setId(String.valueOf(course.getId()));
            }
            courseResponse.setCourseName(course.getCourseName());
            courseResponse.setDuration(course.getDuration());
            return courseResponse;
        }
    }

    public List<CourseResponse> getCourseList(List<Course> courseList) {
        List<CourseResponse> responseList = new ArrayList<>();
        for (Course course : courseList) {
            responseList.add(getCourse(course));
        }
        return responseList;
    }
}
