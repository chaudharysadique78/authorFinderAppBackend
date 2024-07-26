package com.authorFinder.author_service.service;

import com.authorFinder.author_service.entity.ApiResponse;
import com.authorFinder.author_service.entity.Author;
import com.authorFinder.author_service.exception.AuthorNotFoundException;
import com.authorFinder.author_service.repo.AuthorRepo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Value("${thirdparty.url}")
    String baseUrl;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    AuthorRepo authorRepo;

    @Override
    public ApiResponse fetchAuthor(String name) {
        val response = restTemplate.getForEntity(baseUrl + name, ApiResponse.class);
        System.out.println(response.getBody());
        return response.getBody();
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public Author getAuthorById(int id) {
        return authorRepo.findById(id).orElseThrow(() -> new AuthorNotFoundException(String.valueOf(id)));
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepo.findAll();
    }

    @Override
    public Author updateAuthor(Author author, int id) {
        Author existingAuthor = authorRepo.findById(id).orElseThrow(() -> new AuthorNotFoundException(String.valueOf(id)));
        existingAuthor.setName(author.getName());
        existingAuthor.setBio(author.getBio());
        existingAuthor.setBooks(author.getBooks());
        return authorRepo.save(existingAuthor);
    }

    @Override
    public List<Author> getAuthorByName(String name) {
        return authorRepo.findByName(name).orElseThrow(()-> new AuthorNotFoundException(name));
    }
}
