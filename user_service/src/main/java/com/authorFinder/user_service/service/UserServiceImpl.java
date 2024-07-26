package com.authorFinder.user_service.service;

import com.authorFinder.user_service.exception.UserNotFoundException;
import com.authorFinder.user_service.model.Credential;
import com.authorFinder.user_service.model.User;
import com.authorFinder.user_service.repo.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Value("${topic.name}")
    private String topic;

    @Override
    public User registerUSer(User user) throws JsonProcessingException {
        // Publishes the user credentials sent as part of registration to the message bus
        Credential credential = new Credential(user.getEmail(), user.getPassword());
        String credentialString = objectMapper.writeValueAsString(credential);
        kafkaTemplate.send(topic,credentialString);
        System.out.println("send credentials: " +credentialString);
        // Stores the remaining user profile information in the database
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user,int id) {
        User oldUserData = userRepo.findById(id).orElseThrow();
        oldUserData.setPassword(user.getPassword());
        oldUserData.setAge(user.getAge());
        oldUserData.setPhone(user.getPhone());
        return userRepo.save(oldUserData);
    }

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).orElseThrow(()-> new UserNotFoundException(String.valueOf(id)));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
