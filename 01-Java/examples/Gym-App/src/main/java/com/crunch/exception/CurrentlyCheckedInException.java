package com.crunch.exception;

import com.crunch.model.User;

public class CurrentlyCheckedInException extends Exception {

    public CurrentlyCheckedInException(String message){
        super(message);
    }

    public CurrentlyCheckedInException(){
        super();
    }

}
