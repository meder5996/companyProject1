package com.companyproject1.service.impl;

import com.companyproject1.dto.request.GroupRequest;
import com.companyproject1.dto.response.GroupResponse;
import com.companyproject1.entity.Group;
import com.companyproject1.mapper.edit.GroupEdit;
import com.companyproject1.mapper.view.GroupView;
import com.companyproject1.repository.GroupRepository;
import com.companyproject1.service.GroupService;
import com.sun.xml.bind.v2.runtime.reflect.Accessor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupEdit groupEdit;
    private final GroupView groupView;
    private final GroupRepository groupRepository;

    @Override
    public GroupResponse save(GroupRequest groupRequest) {
        return groupView.getGroup(groupRepository.save(groupEdit.create(groupRequest)));
    }

    @Override
    public List<GroupResponse> getAllGroup() {
        List<Group> responseList = groupRepository.findAll();
        return groupView.getGroupList(responseList);
    }

    @Override
    public Optional<Group> getGroupById(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public GroupResponse updateGroup(Long id, GroupRequest groupRequest) {
        Group group = groupRepository.findById(id).get();
        groupEdit.update(group, groupRequest);
        Group group1 = groupRepository.findById(id).get();
        return groupView.getGroup(group1);
    }

    @Override
    public List<GroupResponse> deleteGroup(Long id) {
        groupRepository.deleteById(id);
        List<Group>groupList = groupRepository.findAll();
        return groupView.getGroupList(groupList);
    }

    @Override
    public List<GroupResponse> deleteAllGroup() {
        groupRepository.deleteAll();
        List<Group>groupList = groupRepository.findAll();
        return groupView.getGroupList(groupList);
    }
}
