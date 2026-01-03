package com.project.coaching.center.service;

import com.project.coaching.center.dto.CourseRequestDTO;
import com.project.coaching.center.dto.CourseResponseDTO;
import com.project.coaching.center.dto.StudentRequestDTO;
import com.project.coaching.center.entity.Course;
import com.project.coaching.center.entity.Student;
import com.project.coaching.center.exceptions.CanNotDeleteCourseBecauseItHasStudent;
import com.project.coaching.center.exceptions.CourseNotExistsException;
import com.project.coaching.center.repository.CourseRepository;
import com.project.coaching.center.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public String addCourse(CourseRequestDTO courseRequestDTO) {
        Course course = new Course();
        course.setCourseName(courseRequestDTO.getCourseName());
        course.setDescription(courseRequestDTO.getDescription());
        course.setDurationInMonths(courseRequestDTO.getDurationInMonths());
        courseRepository.save(course);
        return "course saved";
    }

    public List<CourseResponseDTO> getAllCourse() {

        List<Course> courses = courseRepository.findAll();
        List<CourseResponseDTO> list = new ArrayList<>();

        for (int i = 0; i < courses.size(); i++) {
            CourseResponseDTO courseResponseDTO = new CourseResponseDTO();

            courseResponseDTO.setCourseId(courses.get(i).getCourseId());
            courseResponseDTO.setCourseName(courses.get(i).getCourseName());
            courseResponseDTO.setDescription(courses.get(i).getDescription());
            courseResponseDTO.setDurationInMonths(courses.get(i).getDurationInMonths());
            list.add(courseResponseDTO);


        }
        return list;
    }

    public CourseResponseDTO getCourseById(Long courseId){
        Course course= courseRepository.findById(courseId).orElse(null);

        if(course == null){
            throw new CourseNotExistsException("course not exists");
        }
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setCourseId(course.getCourseId());
        courseResponseDTO.setCourseName(course.getCourseName());
        courseResponseDTO.setDescription(course.getDescription());
        courseResponseDTO.setDurationInMonths(course.getDurationInMonths());
        return courseResponseDTO;

    }

    public String updateCourse(Long courseId, CourseRequestDTO courseRequestDTO){
        Course course= courseRepository.findById(courseId).orElse(null);
        if(course==null){
            throw new CourseNotExistsException("course not exists");
        }

        course.setCourseName(courseRequestDTO. getCourseName());
        course.setDescription(courseRequestDTO.getDescription());
        course.setDurationInMonths(courseRequestDTO.getDurationInMonths());
        courseRepository.save(course);
        return "course updated";

    }

    @Autowired
    private StudentRepository studentRepository;

    public String deleteCourse(Long courseId){
Course course= courseRepository.findById(courseId).orElse(null);
if(course==null){
    throw new CourseNotExistsException("course not exists");
}

boolean courseExistsInStudent= studentRepository.existsByCourseId(courseId);
if(!courseExistsInStudent){
    courseRepository.deleteById(courseId);
    return  "Course is deleted";
}
throw new CanNotDeleteCourseBecauseItHasStudent("can not delete course because it has a student");

    }
}
