package com.authorFinder.author_service.controller;

import com.authorFinder.author_service.entity.ApiResponse;
import com.authorFinder.author_service.entity.Author;
import com.authorFinder.author_service.service.AuthorServiceImpl;
import jakarta.ws.rs.POST;
import lombok.Getter;
import lombok.val;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController implements IAuthorController {

    @Autowired
    AuthorServiceImpl authorService;

    @GetMapping("/search")
    public ResponseEntity<ApiResponse> fetchAuthor(@RequestParam String name) {
        val response = authorService.fetchAuthor(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        return new ResponseEntity<>(authorService.addAuthor(author), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthor() {
        return new ResponseEntity<>(authorService.getAllAuthor(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable int id) {
        return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Author> updateAuthor(Author author,@PathVariable int id) {
        return new ResponseEntity<>(authorService.updateAuthor(author,id),HttpStatus.OK);
    }

    @GetMapping("/getbyname/{name}")
    public ResponseEntity<List<Author>> getAuthorByName(@PathVariable String name) {
        return new ResponseEntity<>(authorService.getAuthorByName(name),HttpStatus.OK);
    }
}
