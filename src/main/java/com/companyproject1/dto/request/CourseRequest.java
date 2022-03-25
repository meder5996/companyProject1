package com.companyproject1.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequest {

    @NotNull
    private String courseName;
    @NotNull
    private String duration;

}
