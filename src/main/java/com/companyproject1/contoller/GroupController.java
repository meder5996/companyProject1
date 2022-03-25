package com.companyproject1.contoller;

import com.companyproject1.dto.request.GroupRequest;
import com.companyproject1.dto.response.GroupResponse;
import com.companyproject1.entity.Group;
import com.companyproject1.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/group")
public class GroupController {

    private final GroupService groupService;

    @GetMapping()
    public List<GroupResponse> getAllGroup() {
        return groupService.getAllGroup();
    }

    @PostMapping("/save")
    public GroupResponse saveGroup(@RequestBody GroupRequest groupRequest) {
        return groupService.save(groupRequest);
    }

    @GetMapping("{id}")
    public Optional<Group> getGroupById(@PathVariable Long id) {
        return groupService.getGroupById(id);
    }

    @DeleteMapping("/delete/{id}")
    public List<GroupResponse> deleteGroup(@PathVariable Long id) {
        return groupService.deleteGroup(id);
    }

    @PatchMapping("/update/{id}")
    public GroupResponse updateGroup(@PathVariable Long id, @RequestBody GroupRequest groupRequest) {
        return groupService.updateGroup(id, groupRequest);
    }

    @DeleteMapping("/deleteAllGroup")
    public List<GroupResponse> deleteAllGroup(){
        return groupService.deleteAllGroup();
    }
}
