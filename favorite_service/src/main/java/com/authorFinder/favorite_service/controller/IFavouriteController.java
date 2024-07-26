package com.authorFinder.favorite_service.controller;

import com.authorFinder.author_service.entity.Author;
import com.authorFinder.favorite_service.dto.FavouriteAuthorDTO;
import com.authorFinder.favorite_service.entity.FavouriteAuthor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface IFavouriteController {

    @Operation(summary = "Add favorite author", description = "Add favorite author")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successful operation")
    @Schema(implementation = FavouriteAuthor.class)
    ResponseEntity<FavouriteAuthor> addFavourite(int userId, int authorId);

    @Operation(summary = "Get favorite author", description = "Get favorite author")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successful operation"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "User not found")
    })
    @Schema(implementation = FavouriteAuthorDTO.class)
    ResponseEntity<FavouriteAuthorDTO> getFavouriteAuthor(int userId);

    @Operation(summary = "Remove favorite author", description = "Remove favorite author")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successful operation"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "User not found")
    })
    @Schema(implementation = FavouriteAuthorDTO.class)
    ResponseEntity<FavouriteAuthorDTO> removeFavouriteAuthor(int userId, int authorId);

}
