package com.companyproject1.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseResponse {
    private String id;
    private String courseName;
    private String duration;
    private Long companyId;
}
