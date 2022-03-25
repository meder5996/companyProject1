package com.companyproject1.mapper.view;

import com.companyproject1.dto.response.GroupResponse;
import com.companyproject1.entity.Group;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupView {

    public GroupResponse getGroup(Group group) {
        if (group == null) {
            return null;
        } else {
            GroupResponse groupResponse = new GroupResponse();
            if (group.getId() != null) {
                groupResponse.setId(String.valueOf(group.getId()));
            }
            groupResponse.setGroupName(group.getGroupName());
            groupResponse.setDateOfStart(group.getDateOfStart());
            groupResponse.setDateOfFinish(group.getDateOfFinish());
            groupResponse.setStudentList(group.getStudentList());
            return groupResponse;
        }
    }

    public List<GroupResponse> getGroupList(List<Group> groupList) {
        List<GroupResponse> responseList = new ArrayList<>();
        for (Group group : groupList) {
            responseList.add(getGroup(group));
        }
        return responseList;
    }
}
