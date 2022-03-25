package com.companyproject1.contoller;

import com.companyproject1.dto.request.CourseRequest;
import com.companyproject1.dto.response.CourseResponse;
import com.companyproject1.entity.Course;
import com.companyproject1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping()
    public List<CourseResponse> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping("{id}")
    public Optional<Course> getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @PostMapping("/save/{id}")
    public CourseResponse saveCourse(@RequestBody CourseRequest courseRequest, @PathVariable Long id) {
        return courseService.save(courseRequest, id);
    }

    @PatchMapping("/update/{id}")
    public CourseResponse updateCourse(@PathVariable Long id, @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourse(id, courseRequest);
    }

    @DeleteMapping("delete/{id}")
    public List<CourseResponse> deleteCourse(@PathVariable Long id){
        return courseService.deleteCourse(id);
    }

    @DeleteMapping("/deleteALlCourse")
    public List<CourseResponse> deleteAllCourse(){
        return courseService.deleteAllCourse();
    }
}
