package com.authorFinder.apigateway_service.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private String secret = "secret";

    public String extractUsername(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    public Claims getAllClaimsFromToken(String token) {
        if(token!=null && !(token.startsWith("Bearer"))){
            throw new RuntimeException("JWT Token is missing");
        }
        String jwtToken = token.substring(7);
        return (Claims)Jwts.parser().setSigningKey(secret).parse(jwtToken).getBody();
    }

    public Boolean isTokenExpired(String token) {
        return getAllClaimsFromToken(token).getExpiration().before(new Date());
    }

    public boolean isInvalid(String token) {
        return this.isTokenExpired(token);
    }
}
