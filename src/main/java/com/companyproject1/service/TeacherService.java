package com.companyproject1.service;

import com.companyproject1.dto.request.TeacherRequest;
import com.companyproject1.dto.response.TeacherResponse;
import com.companyproject1.entity.Teacher;

import java.util.List;

public interface TeacherService {

    TeacherResponse save(TeacherRequest teacherRequest, Long id);

    List<TeacherResponse> getAllTeacher();

    TeacherResponse getTeacherById(Long id);

    TeacherResponse updateTeacher(Long id, TeacherRequest teacherRequest);

    List<TeacherResponse> deleteTeacher(Long id);

    List<TeacherResponse> deleteAllTeacher();
}
