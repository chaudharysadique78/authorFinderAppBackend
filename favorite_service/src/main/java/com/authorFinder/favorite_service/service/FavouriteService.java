package com.authorFinder.favorite_service.service;

import com.authorFinder.favorite_service.dto.FavouriteAuthorDTO;
import com.authorFinder.favorite_service.entity.FavouriteAuthor;

public interface FavouriteService {

    FavouriteAuthor addFavourite(int userId, int authorId);

    FavouriteAuthorDTO getFavouriteAuthor(int userId);

    FavouriteAuthorDTO removeFavouriteAuthor(int userId, int authorId);

}
