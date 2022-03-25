package com.companyproject1.service;

import com.companyproject1.dto.request.CourseRequest;
import com.companyproject1.dto.response.CourseResponse;
import com.companyproject1.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    CourseResponse save(CourseRequest courseRequest, Long id);

    List<CourseResponse> getAllCourse();

    Optional<Course> getCourseById(Long id);

    CourseResponse updateCourse(Long id, CourseRequest courseRequest);

    List<CourseResponse> deleteCourse(Long id);

    List<CourseResponse> deleteAllCourse();

}
