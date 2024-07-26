package com.authorFinder.author_service.exception;

public class AuthorNotFoundException extends RuntimeException{

    public AuthorNotFoundException(String id){
        super("Author Not Found with given id: "+id);
    }


}
