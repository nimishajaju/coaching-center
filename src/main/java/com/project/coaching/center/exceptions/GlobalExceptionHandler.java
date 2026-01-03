package com.project.coaching.center.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException sms){
        return new ResponseEntity<>(sms.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<String> handleEmailAlreadyException (EmailAlreadyExistsException sms){
        return new ResponseEntity<>(sms.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<String> handleCourseNotFoundException(CourseNotFoundException sms){
        return new ResponseEntity<>(sms.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CourseNotExistsException.class)
    public ResponseEntity<String> handleCourseNotExistsException (CourseNotExistsException msg){
        return new ResponseEntity<>(msg.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CanNotDeleteCourseBecauseItHasStudent.class)
    public ResponseEntity<String> handleCanNotDeleteCourseBecauseItHasStudent (CanNotDeleteCourseBecauseItHasStudent msg){
        return new ResponseEntity<>(msg.getMessage(),HttpStatus.NOT_FOUND);
    }


}
