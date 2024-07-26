package com.authorFinder.favorite_service.controller;

import com.authorFinder.favorite_service.dto.FavouriteAuthorDTO;
import com.authorFinder.favorite_service.entity.FavouriteAuthor;
import com.authorFinder.favorite_service.service.FavouriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fav")
public class FavouriteController implements IFavouriteController {

    @Autowired
    private FavouriteServiceImpl favouriteService;

    @PutMapping("/addfav/{userId}/{authorId}")
    public ResponseEntity<FavouriteAuthor> addFavourite(@PathVariable int userId, @PathVariable int authorId) {
        return new ResponseEntity<>(favouriteService.addFavourite(userId, authorId), HttpStatus.OK);
    }

    @GetMapping("/getfav/{userId}")
    public ResponseEntity<FavouriteAuthorDTO> getFavouriteAuthor(@PathVariable int userId) {
        return new ResponseEntity<>(favouriteService.getFavouriteAuthor(userId), HttpStatus.OK);
    }

    @DeleteMapping("/deletefav/{userId}/{authorId}")
    public ResponseEntity<FavouriteAuthorDTO> removeFavouriteAuthor(@PathVariable int userId, @PathVariable int authorId) {
        return new ResponseEntity<>(favouriteService.removeFavouriteAuthor(userId, authorId), HttpStatus.OK);
    }
}
