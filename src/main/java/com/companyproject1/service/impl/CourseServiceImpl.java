package com.companyproject1.service.impl;


import com.companyproject1.dto.request.CourseRequest;
import com.companyproject1.dto.response.CourseResponse;
import com.companyproject1.entity.Course;
import com.companyproject1.mapper.edit.CourseEdit;
import com.companyproject1.mapper.view.CourseView;
import com.companyproject1.repository.CourseRepository;
import com.companyproject1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseEdit courseEdit;
    private final CourseView courseView;
    private final CourseRepository courseRepository;

    @Override
    public CourseResponse save(CourseRequest courseRequest, Long id) {
        return courseView.getCourse(courseRepository.save(courseEdit.create(courseRequest, id)));
    }

    @Override
    public List<CourseResponse> getAllCourse() {
        List<Course> courseList = courseRepository.findAll();
        return courseView.getCourseList(courseList);
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public CourseResponse updateCourse(Long id, CourseRequest courseRequest) {
        Course course = courseRepository.findById(id).get();
        courseEdit.update(course, courseRequest);
        Course course1 = courseRepository.findById(id).get();
        return courseView.getCourse(course1);
    }

    @Override
    public List<CourseResponse> deleteCourse(Long id) {
        courseRepository.deleteById(id);
        List<Course> courseList = courseRepository.findAll();
        return courseView.getCourseList(courseList);
    }

    @Override
    public List<CourseResponse> deleteAllCourse() {
        courseRepository.deleteAll();
        List<Course>courseList = courseRepository.findAll();
        return courseView.getCourseList(courseList);
    }
}
