package com.companyproject1.service;

import com.companyproject1.dto.request.GroupRequest;
import com.companyproject1.dto.response.GroupResponse;
import com.companyproject1.entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    GroupResponse save(GroupRequest groupRequest);

    List<GroupResponse> getAllGroup();

    Optional<Group> getGroupById(Long id);

    GroupResponse updateGroup(Long id, GroupRequest groupRequest);

    List<GroupResponse> deleteGroup(Long id);

    List<GroupResponse> deleteAllGroup();
}
