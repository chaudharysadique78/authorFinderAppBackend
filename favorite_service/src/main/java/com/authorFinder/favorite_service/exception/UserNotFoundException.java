package com.authorFinder.favorite_service.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String id) {
        super("User Not Found with given id: " + id);
    }
}
