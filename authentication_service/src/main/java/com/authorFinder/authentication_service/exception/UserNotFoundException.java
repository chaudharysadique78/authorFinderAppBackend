package com.authorFinder.authentication_service.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String email){
        super("User Not Found with Email: "+email);
    }


}
