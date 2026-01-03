package com.project.coaching.center.exceptions;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(String msg){
        super(msg);
    }
}
