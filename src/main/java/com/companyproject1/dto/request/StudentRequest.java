package com.companyproject1.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {

    @NotNull
    private String firstName;
    @NotNull
    private String email;
    @NotNull
    private String lastName;
    @NotNull
    private String studyFormat;
}
