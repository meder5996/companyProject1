package com.companyproject1.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentResponse {

    private String id;
    private String firstName;
    private String email;
    private String lastName;
    private String studyFormat;
}
