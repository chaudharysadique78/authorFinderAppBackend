package com.authorFinder.user_service.service;

import com.authorFinder.user_service.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    User registerUSer(User user) throws JsonProcessingException;
    public User updateUser(User user,int id);
    User getUserById(int id);

    List<User> getAllUsers();
}
