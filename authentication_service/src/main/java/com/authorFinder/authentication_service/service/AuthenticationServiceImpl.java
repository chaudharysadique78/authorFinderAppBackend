package com.authorFinder.authentication_service.service;

import com.authorFinder.authentication_service.exception.UserNotFoundException;
import com.authorFinder.authentication_service.model.Credential;
import com.authorFinder.authentication_service.repo.CredentialRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final String SECRET_KEY = "secret";
    private static final String userTopic = "${topic.name}";
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CredentialRepo credentialRepo;

    @KafkaListener(topics = userTopic)
    public void kafkaListener(String message) throws JsonProcessingException {
        //Consuming user credential from the message bus and storing it in the database.
        log.info("message consumed:- " + message);
        Credential credential = objectMapper.readValue(message, Credential.class);
        credentialRepo.save(credential);
        System.out.println("message saved to DB table: credential");
    }

    @Override
    public Map<String, String> login(String email, String password) {
        // generates a JWT token
        Map<String, String> token;
        Credential user = credentialRepo.findByEmailAndPassword(email, password);
        if (user != null) {
            token = generateToken(user);
        } else {
            throw new UserNotFoundException(email);
        }
        return token;
    }

    public static Map<String, String> generateToken(Credential user) {
        String token = Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 30000000))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return tokenMap;
    }

}
