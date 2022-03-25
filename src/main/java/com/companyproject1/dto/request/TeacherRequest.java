package com.companyproject1.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherRequest {

    @NotNull
    private String firstName;
    @NotNull
    private String email;
    @NotNull
    private String lastName;
}
