package com.authorFinder.authentication_service.controller;

import com.authorFinder.authentication_service.model.Credential;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
@Tag(name = "Authentication API", description = "Authentication API for managing authentication")
public interface IAuthenticationController {
    @Operation(summary = "Login users", description = "Generate JWT token")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    ResponseEntity<Map<String, String>> loginUser(Credential credential);

}
