package com.companyproject1.dto.response;

import com.companyproject1.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupResponse {
    private String id;
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
    private List<Student> studentList;
}
