package com.companyproject1.dto.response;

import com.companyproject1.entity.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyResponse {
    private String id;
    private String companyName;
    private String locatedCountry;
    private List<Course> courseList;
}
