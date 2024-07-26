package com.authorFinder.authentication_service.service;

import java.util.Map;

public interface AuthenticationService {

    Map<String,String> login(String email,String password);

}
