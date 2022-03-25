package com.companyproject1.service.impl;

import com.companyproject1.dto.request.TeacherRequest;
import com.companyproject1.dto.response.TeacherResponse;
import com.companyproject1.entity.Teacher;
import com.companyproject1.mapper.edit.TeacherEdit;
import com.companyproject1.mapper.view.TeacherView;
import com.companyproject1.repository.TeacherRepository;
import com.companyproject1.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherEdit teacherEdit;
    private final TeacherView teacherView;
    private final TeacherRepository teacherRepository;


    @Override
    public TeacherResponse save(TeacherRequest teacherRequest, Long id) {
        return teacherView.getTeacher(teacherRepository.save(teacherEdit.create(teacherRequest, id)));
    }

    @Override
    public List<TeacherResponse> getAllTeacher() {
        List<Teacher> responseList = teacherRepository.findAll();
        return teacherView.getTeacherResponseList(responseList);
    }

    @Override
    public TeacherResponse getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).get();
        return teacherView.getTeacher(teacher);
    }

    public TeacherResponse updateTeacher(Long id, TeacherRequest teacherRequest) {
        Teacher teacher = teacherRepository.findById(id).get();
        teacherEdit.update(teacher, teacherRequest);
        Teacher teacher1 = teacherRepository.findById(id).get();
        return teacherView.getTeacher(teacher1);
    }

    @Override
    public List<TeacherResponse> deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
        List<Teacher>teacherList = teacherRepository.findAll();
        return teacherView.getTeacherResponseList(teacherList);
    }

    @Override
    public List<TeacherResponse> deleteAllTeacher() {
        teacherRepository.deleteAll();
        List<Teacher>teacherList = teacherRepository.findAll();
        return teacherView.getTeacherResponseList(teacherList);
    }
}
