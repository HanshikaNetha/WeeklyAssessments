package com.example.SpringRestOnlineCourseManagment.service;

import com.example.SpringRestOnlineCourseManagment.dto.CourseRequest;
import com.example.SpringRestOnlineCourseManagment.dto.CourseResponse;
import com.example.SpringRestOnlineCourseManagment.dto.PageResponse;
import com.example.SpringRestOnlineCourseManagment.entity.Course;
import com.example.SpringRestOnlineCourseManagment.entity.User;
import com.example.SpringRestOnlineCourseManagment.repository.CourseRepository;
import com.example.SpringRestOnlineCourseManagment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public CourseResponse addCourse(CourseRequest courseRequest, Long instructorId){
        User instructor=userRepository.findById(instructorId).orElseThrow(()->new RuntimeException("Instructor id not found"));
        Course course=modelMapper.map(courseRequest, Course.class);
        course.setInstructor(instructor);
        course.setCreatedAt(LocalDate.now());
        Course savedCourse=courseRepository.save(course);
        CourseResponse courseResponse=modelMapper.map(savedCourse, CourseResponse.class);
        return courseResponse;
    }

    public CourseResponse updateCourse(Long id, CourseRequest courseRequest){
        Course existingcourse=courseRepository.findById(id).orElseThrow(()->new RuntimeException("course not found"));
        existingcourse.setUpdatedAt(LocalDate.now());
        existingcourse.setTitle(courseRequest.getTitle());
        existingcourse.setDescription(courseRequest.getDescription());
        existingcourse.setDuration(courseRequest.getDuration());
        existingcourse.setPrice(courseRequest.getPrice());
        existingcourse.setLevel(courseRequest.getLevel());
        Course saveCourse=courseRepository.save(existingcourse);
        CourseResponse courseResponse=modelMapper.map(saveCourse, CourseResponse.class);
        return courseResponse;
    }

    public List<CourseResponse> getAllCourses(){
        List<Course> courses=courseRepository.findAll();
        List<CourseResponse> courseResponses=courses.stream().map(i->modelMapper.map(i, CourseResponse.class)).toList();
        return courseResponses;
    }

    public CourseResponse getCourse(Long id){
        Course course=courseRepository.findById(id).orElseThrow(()->new RuntimeException("course not found"));
        CourseResponse courseResponse=modelMapper.map(course, CourseResponse.class);
        return courseResponse;
    }

    public CourseResponse deleteCourse(Long id){
        Course course=courseRepository.findById(id).orElseThrow(()->new RuntimeException("coursee not found"));
        courseRepository.delete(course);
        return modelMapper.map(course, CourseResponse.class);
    }

    public PageResponse<CourseResponse> getAllCoursePage(int page, int size, String sortBy, String sortingWay){
        Sort whichSort=sortingWay.equalsIgnoreCase("desc")?Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
        Pageable pageable= PageRequest.of(page, size, whichSort);
        Page<Course> coursePage=courseRepository.findAll(pageable);
        List<CourseResponse> courseResponseList=coursePage.getContent().stream().map(i->modelMapper.map(i, CourseResponse.class)).toList();
        return new PageResponse<>(courseResponseList, coursePage.getNumber(), coursePage.getSize(), coursePage.getTotalElements(), coursePage.getTotalPages());
    }

}
