package com.companyproject1.contoller;

import com.companyproject1.dto.request.StudentRequest;
import com.companyproject1.dto.response.StudentResponse;
import com.companyproject1.entity.Student;
import com.companyproject1.service.StudentService;
import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public List<StudentResponse> getAllStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping("/save/{id}")
    public StudentResponse saveStudent(@RequestBody StudentRequest studentRequest, @PathVariable Long id){
        return studentService.save(studentRequest, id);
    }

    @GetMapping("{id}")
    public StudentResponse getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PatchMapping("update/{id}")
    public StudentResponse updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest){
        return studentService.updateStudent(id, studentRequest);
    }

    @DeleteMapping("/delete/{id}")
    public List<StudentResponse> deleteStudentById(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

    @DeleteMapping("/deleteAllStudent")
    public List<StudentResponse> deleteAllStudent(){
        return studentService.deleteAllStudent();
    }
}
