package com.authorFinder.favorite_service.exception;

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
        responseMap.put("message", "User not found with Given id");
        return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<Map<String, String>> authorNotFound() {
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "Author Not Found with given id");
        return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoFavouriteException.class)
    public ResponseEntity<Map<String, String>> noFavouriteFound() {
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "Author Not Found with given id");
        return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Map<String, String>> commonException() {
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("message", "Author already added to favourite list with given id");
        return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
    }
}
