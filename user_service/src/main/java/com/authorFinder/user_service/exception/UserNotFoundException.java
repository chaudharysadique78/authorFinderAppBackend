package com.authorFinder.user_service.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String email){
        super("User Not Found with given id: "+email);
    }


}
