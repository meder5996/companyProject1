package com.companyproject1.mapper.view;

import com.companyproject1.dto.response.TeacherResponse;
import com.companyproject1.entity.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherView {
    public TeacherResponse getTeacher(Teacher teacher){
        if (teacher == null){
            return null;
        }else {
            TeacherResponse teacherResponse = new TeacherResponse();

            if (teacher.getId()!=null) {
                teacherResponse.setId(String.valueOf(teacher.getId()));
            }
                teacherResponse.setFirstName(teacher.getFirstName());
                teacherResponse.setEmail(teacher.getEmail());
                teacherResponse.setLastName(teacher.getLastName());
            return teacherResponse;
        }
    }

    public List<TeacherResponse> getTeacherResponseList(List<Teacher>teacherList){
        List<TeacherResponse>responseList = new ArrayList<>();
        for (Teacher teacher : teacherList){
            responseList.add(getTeacher(teacher));
        }
        return responseList;
    }
}
