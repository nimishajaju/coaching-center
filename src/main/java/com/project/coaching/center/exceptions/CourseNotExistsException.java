package com.project.coaching.center.exceptions;

public class CourseNotExistsException extends RuntimeException{

    public CourseNotExistsException (String msg){
        super(msg);
    }

}
