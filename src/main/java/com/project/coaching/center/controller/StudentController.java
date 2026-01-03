package com.project.coaching.center.controller;

import com.project.coaching.center.dto.StudentRequestDTO;
import com.project.coaching.center.dto.StudentResponseDTO;
import com.project.coaching.center.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coachingCenter")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        return studentService.addStudent(studentRequestDTO);
    }

    @GetMapping("/getAllStudent")
    public List<StudentResponseDTO> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/getStudentById/{id}")
    public StudentResponseDTO getStudentById(@PathVariable ("id") Long studentId){
        return  studentService.getStudentById(studentId);
    }

    @PutMapping ("/updateStudent/{id}")
    public  String updateStudent(
            @PathVariable ("id") Long studentId,
            @RequestBody StudentRequestDTO studentRequestDTO){
        return studentService.updateStudent( studentId, studentRequestDTO);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable ("id") Long studentId){
        return  studentService.deleteStudent(studentId);
    }

    @GetMapping("/getAllStudentOfACourse/{id}")
    public List<StudentResponseDTO> getAllStudentOfACourse(@PathVariable ("id") Long courseId){
        return  studentService.getAllStudentOfACourse(courseId);
    }

    @GetMapping("/getStudentByName/{name}")
    public List<StudentResponseDTO> getStudentByName(@PathVariable ("name") String studentName){
        return studentService.getStudentByName(studentName);
    }


}
