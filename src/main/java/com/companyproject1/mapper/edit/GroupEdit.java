package com.companyproject1.mapper.edit;

import com.companyproject1.dto.request.GroupRequest;
import com.companyproject1.entity.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupEdit {

    public Group create(GroupRequest groupRequest) {
        if (groupRequest == null) {
            return null;
        } else {
            Group group = new Group();
            group.setGroupName(groupRequest.getGroupName());
            group.setDateOfFinish(groupRequest.getDateOfFinish());
            group.setDateOfStart(groupRequest.getDateOfStart());
            return group;
        }
    }

    public void update(Group group, GroupRequest groupRequest) {
        group.setGroupName(groupRequest.getGroupName());
        group.setDateOfFinish(groupRequest.getDateOfFinish());
        group.setDateOfStart(groupRequest.getDateOfStart());
    }
}
