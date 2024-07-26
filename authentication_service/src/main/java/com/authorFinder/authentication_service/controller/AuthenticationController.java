package com.authorFinder.authentication_service.controller;

import com.authorFinder.authentication_service.model.Credential;
import com.authorFinder.authentication_service.service.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController implements IAuthenticationController {

    @Autowired
    private AuthenticationServiceImpl authenticationService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Credential credential) {
        Map<String, String> token = authenticationService.login(credential.getEmail(), credential.getPassword());
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

}
