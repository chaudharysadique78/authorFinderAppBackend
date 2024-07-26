package com.authorFinder.author_service.repo;

import com.authorFinder.author_service.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {

    Optional<List<Author>> findByName(String name);

}
