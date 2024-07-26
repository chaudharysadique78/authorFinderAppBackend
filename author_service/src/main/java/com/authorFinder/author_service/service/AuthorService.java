package com.authorFinder.author_service.service;

import com.authorFinder.author_service.entity.ApiResponse;
import com.authorFinder.author_service.entity.Author;
import lombok.val;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    ApiResponse fetchAuthor(String name);

    Author addAuthor(Author author);

    Author getAuthorById(int id);

    List<Author> getAllAuthor();

    Author updateAuthor(Author author, int id);

    List<Author> getAuthorByName(String name);

}
