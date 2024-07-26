package com.authorFinder.author_service.controller;

import com.authorFinder.author_service.entity.ApiResponse;
import com.authorFinder.author_service.entity.Author;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.val;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Author API", description = "Author API for search author from third party API")
public interface IAuthorController {

    @Operation(summary = "Fetch details from Open-library API", description = "Fetch details from Open-library API")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successful operation")
    @Schema(implementation = ApiResponse.class)
    ResponseEntity<ApiResponse> fetchAuthor(String name);

    @Operation(summary = "Add author", description = "Add author")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successful operation")
    @Schema(implementation = Author.class)
    ResponseEntity<Author> addAuthor(Author author);

    @Operation(summary = "Get all author", description = "Get all author")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successful operation")
    ResponseEntity<List<Author>> getAllAuthor();

    @Operation(summary = "Get author", description = "Get author")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successful operation"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "User not found")
    })
    @Schema(implementation = Author.class)
    ResponseEntity<Author> getAuthorById(int id);

    @Operation(summary = "Update author", description = "Update author")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successful operation")
    @Schema(implementation = Author.class)
    ResponseEntity<Author> updateAuthor(Author author, int id);

    @Operation(summary = "Get author by name", description = "Get author by name")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successful operation"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "User not found")
    })
    @Schema(implementation = Author.class)
    ResponseEntity<List<Author>> getAuthorByName(String name);

}
