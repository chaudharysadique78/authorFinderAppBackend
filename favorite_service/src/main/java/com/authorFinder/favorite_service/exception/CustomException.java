package com.authorFinder.favorite_service.exception;

public class CustomException extends RuntimeException{

    public CustomException(String msg,String id){
        super(msg+id);
    }
}
