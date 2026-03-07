package com.example.SpringRestOnlineCourseManagment.controller;

import com.example.SpringRestOnlineCourseManagment.dto.CourseRequest;
import com.example.SpringRestOnlineCourseManagment.dto.CourseResponse;
import com.example.SpringRestOnlineCourseManagment.dto.PageResponse;
import com.example.SpringRestOnlineCourseManagment.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity<String> addCourse(@RequestBody CourseRequest courseRequest, @RequestParam("id") Long id){
        CourseResponse courseResponse=courseService.addCourse(courseRequest, id);
        return ResponseEntity.ok(courseResponse.getTitle()+" is added");
    }

    @PutMapping("/updateCourse/{id}")
    public ResponseEntity<String> updateCourse(@RequestBody CourseRequest courseRequest, @PathVariable("id") Long id){
        CourseResponse courseResponse=courseService.updateCourse(id, courseRequest);
        return ResponseEntity.ok(courseResponse.getTitle()+"is updated");
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") Long id){
        CourseResponse courseResponse=courseService.deleteCourse(id);
        return ResponseEntity.ok(courseResponse.getTitle()+" is deleted");
    }

    @GetMapping("/getAllCourses")
    public ResponseEntity<List<CourseResponse>> getAllCourses(){
        List<CourseResponse> courseResponseList=courseService.getAllCourses();
        return ResponseEntity.ok(courseResponseList);
    }

    @GetMapping("/getCourse/{id}")
    public ResponseEntity<CourseResponse> getCourse(@PathVariable("id") Long id){
        CourseResponse courseResponse=courseService.getCourse(id);
        return ResponseEntity.ok(courseResponse);
    }

    @GetMapping("/getCoursesPage")
    public ResponseEntity<PageResponse<CourseResponse>> getAllCoursesPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "courseId") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ){
        PageResponse<CourseResponse> rui=courseService.getAllCoursePage(page, size, sortBy, direction);
        return ResponseEntity.ok(rui);
    }
}
