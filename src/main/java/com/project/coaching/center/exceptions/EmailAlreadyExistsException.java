package com.project.coaching.center.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{

    public EmailAlreadyExistsException (String msg){

        super(msg);
    }

}
