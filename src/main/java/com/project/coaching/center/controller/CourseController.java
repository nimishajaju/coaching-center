package com.project.coaching.center.controller;

import com.project.coaching.center.dto.CourseRequestDTO;
import com.project.coaching.center.dto.CourseResponseDTO;
import com.project.coaching.center.entity.Course;
import com.project.coaching.center.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coachingCenter")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourse")
    public String addCourse(@RequestBody CourseRequestDTO courseRequestDTO){
        return courseService.addCourse(courseRequestDTO);
    }

    @GetMapping("/getAllcourses")
    public List<CourseResponseDTO> getAllCourse(){
        return courseService.getAllCourse();
    }

    @GetMapping("/getCourseById/{id}")
    public CourseResponseDTO getCourseById(@PathVariable ("id") Long courseId){
        return courseService.getCourseById(courseId);
    }

    @PutMapping("/updateCourse/{id}")
    public String updateCourse(
            @PathVariable ("id") Long courseId,
            @RequestBody CourseRequestDTO courseRequestDTO) {
        return courseService.updateCourse(courseId, courseRequestDTO);


    }

    @DeleteMapping ( "/deleteCourse/{id}")
    public String deleteCourse(@PathVariable("id") Long courseId){
        return courseService.deleteCourse(courseId);
    }





}
