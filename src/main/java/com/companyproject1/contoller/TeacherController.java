package com.companyproject1.contoller;

import com.companyproject1.dto.request.TeacherRequest;
import com.companyproject1.dto.response.TeacherResponse;
import com.companyproject1.entity.Teacher;
import com.companyproject1.repository.TeacherRepository;
import com.companyproject1.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/save/{id}")
    public TeacherResponse saveTeacher(@RequestBody TeacherRequest teacherRequest, @PathVariable Long id) {
        return teacherService.save(teacherRequest,id);
    }

    @GetMapping()
    public List<TeacherResponse> getAllTeacher() {
        return teacherService.getAllTeacher();
    }

    @GetMapping("/{id}")
    public TeacherResponse getTeacherById(@PathVariable Long id){
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping("/delete/{id}")
    public List<TeacherResponse> deleteTeacherById(@PathVariable Long id){
        return teacherService.deleteTeacher(id);
    }

    @PatchMapping("/update/{id}")
    public TeacherResponse updateTeacherById(@PathVariable Long id, @RequestBody TeacherRequest teacherRequest){
        return teacherService.updateTeacher(id, teacherRequest);
    }

    @DeleteMapping("/deleteAllTeacher")
    public List<TeacherResponse> deleteAllTeacher(){
        return teacherService.deleteAllTeacher();
    }
}
