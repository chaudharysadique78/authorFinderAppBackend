package com.authorFinder.authentication_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> userNotFound() {
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "User Not Found with given email and password");
        return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
    }
}
