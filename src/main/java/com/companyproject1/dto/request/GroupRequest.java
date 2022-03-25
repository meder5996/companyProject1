package com.companyproject1.dto.request;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class GroupRequest {

    @NotNull
    private String groupName;
    @NotNull
    private String dateOfStart;
    @NotNull
    private String dateOfFinish;
}
