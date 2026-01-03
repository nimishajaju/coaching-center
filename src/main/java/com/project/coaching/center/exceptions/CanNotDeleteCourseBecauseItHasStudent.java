package com.project.coaching.center.exceptions;

public class CanNotDeleteCourseBecauseItHasStudent extends RuntimeException{

    public CanNotDeleteCourseBecauseItHasStudent(String msg){
        super(msg);
    }
}
