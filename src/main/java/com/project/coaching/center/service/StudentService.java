package com.project.coaching.center.service;

import com.project.coaching.center.dto.StudentRequestDTO;
import com.project.coaching.center.dto.StudentResponseDTO;
import com.project.coaching.center.entity.Student;
import com.project.coaching.center.exceptions.*;
import com.project.coaching.center.repository.CourseRepository;
import com.project.coaching.center.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public String addStudent(StudentRequestDTO studentRequestDTO){
        boolean existsEmail = studentRepository.existsByEmail(studentRequestDTO.getEmail());
        if(existsEmail){
            throw new EmailAlreadyExistsException("email already exists");
        }

boolean existsCourse= courseRepository.existsById(studentRequestDTO.getCourseId());
        if(!existsCourse){
            throw new CourseNotFoundException("course id not exists");
        }

        Student student = new Student();
        student.setStudentName(studentRequestDTO.getStudentName());
        student.setCourseId(studentRequestDTO.getCourseId());
        student.setEmail(studentRequestDTO.getEmail());
      studentRepository.save(student);
return "saved student";
    }

    public List<StudentResponseDTO> getAllStudent(){
        List<Student> students = studentRepository.findAll();

        List<StudentResponseDTO> list= new ArrayList<>();
        for ( int i = 0; i< students.size(); i++){

            StudentResponseDTO studentResponseDTO= new StudentResponseDTO();

            studentResponseDTO.setStudentId(students.get(i).getStudentId());
            studentResponseDTO.setStudentName(students.get(i).getStudentName());
            studentResponseDTO.setEmail(students.get(i).getEmail());
            studentResponseDTO.setCourseId(students.get(i).getCourseId());
            list.add(studentResponseDTO);



        }
        return list;
    }

    public StudentResponseDTO getStudentById(Long studentId){
        Student student = studentRepository.findById(studentId).orElse(null);
        if(student == null)
            throw new StudentNotFoundException("No Student Found");

        StudentResponseDTO studentResponseDTO= new StudentResponseDTO();
        studentResponseDTO.setStudentId(student.getStudentId());
        studentResponseDTO.setCourseId(student.getCourseId());
        studentResponseDTO.setStudentName(student.getStudentName());
        studentResponseDTO.setEmail(student.getEmail());
        return studentResponseDTO;
    }

    public String updateStudent(Long studentId, StudentRequestDTO studentRequestDTO){
    Student student = studentRepository.findById(studentId).orElse(null);
    if(student== null){
        throw new StudentNotFoundException("student not found for update");
    }

    student.setStudentName(studentRequestDTO.getStudentName());
    student.setEmail(studentRequestDTO.getEmail());
    student.setCourseId(studentRequestDTO.getCourseId());
    studentRepository.save(student);
    return "update student";
    }

    public String deleteStudent(Long studentId){
        boolean existsStudent= studentRepository.existsById(studentId);
        if(!existsStudent){

            throw new StudentNotFoundException("student not exists to delete");
        }
        studentRepository.deleteById(studentId);
        return "student deleted";
    }

    public List<StudentResponseDTO> getAllStudentOfACourse(Long courseId){
        List<Student> students= studentRepository.findByCourseId(courseId);

        List<StudentResponseDTO> list= new ArrayList<>();
        for ( int i = 0; i< students.size(); i++){
            StudentResponseDTO studentResponseDTO= new StudentResponseDTO();
            studentResponseDTO.setStudentId(students.get(i).getStudentId());
            studentResponseDTO.setStudentName(students.get(i).getStudentName());
            studentResponseDTO.setCourseId(students.get(i).getCourseId());
            studentResponseDTO.setEmail(students.get(i).getEmail());
            list.add(studentResponseDTO);
        }
        return list;
    }

    public List<StudentResponseDTO> getStudentByName(String studentName){
    List<Student> studentss= studentRepository.findByStudentNameContainingIgnoreCase(studentName);

    List<StudentResponseDTO> list= new ArrayList<>();

    for (int i = 0; i <studentss.size();i++){
        StudentResponseDTO studentResponseDTO= new StudentResponseDTO();
        studentResponseDTO.setStudentId(studentss.get(i).getStudentId());
        studentResponseDTO.setStudentName(studentss.get(i).getStudentName());
        studentResponseDTO.setEmail(studentss.get(i).getEmail());
        studentResponseDTO.setCourseId(studentss.get(i).getCourseId());
        list.add(studentResponseDTO);

    }
    return list;
    }
}
