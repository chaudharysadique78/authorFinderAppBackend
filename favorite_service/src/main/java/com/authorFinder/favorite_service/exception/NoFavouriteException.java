package com.authorFinder.favorite_service.exception;

public class NoFavouriteException extends RuntimeException {

    public NoFavouriteException(String id) {
        super("No favourites found for given userId: " + id);
    }
}
