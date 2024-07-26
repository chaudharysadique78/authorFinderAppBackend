package com.authorFinder.favorite_service.dto;

import com.authorFinder.favorite_service.entity.Author;

import java.util.List;

public record FavouriteAuthorDTO(List<Author> authors) {
}
