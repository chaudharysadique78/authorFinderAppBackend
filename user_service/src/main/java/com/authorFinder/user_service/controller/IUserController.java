package com.authorFinder.user_service.controller;

import com.authorFinder.user_service.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;


@Tag(name = "User API", description = "User API for managing Users")
public interface IUserController {

    @Operation(summary = "Register users", description = "Register users")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @Schema(implementation = User.class)
    ResponseEntity<User> registerUser(User user) throws JsonProcessingException;

    @Operation(summary = "Update users", description = "Update users")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @Schema(implementation = User.class)
    ResponseEntity<User> updateUser(User user, int id);

    @Operation(summary = "Get user", description = "Get user")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @Schema(implementation = User.class)
    ResponseEntity<User> getUserById(int id);


    @Operation(summary = "Get all user", description = "Get all user")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @Schema(implementation = User.class)
    ResponseEntity<List<User>> getAllUsers();

    @Operation(summary = "Get user by Email", description = "Get user by Email")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    ResponseEntity<User> findUserByEmail(String email);

}
