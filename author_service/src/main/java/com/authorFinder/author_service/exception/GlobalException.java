package com.authorFinder.author_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<Map<String, String>> authorNotFound() {
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "Author Not Found with given id");
        return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
    }
}
