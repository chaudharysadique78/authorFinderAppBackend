package com.authorFinder.favorite_service.repo;

import com.authorFinder.favorite_service.entity.Author;
import com.authorFinder.favorite_service.entity.FavouriteAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavouriteAuthorRepo extends JpaRepository<FavouriteAuthor, Integer> {

    Optional<FavouriteAuthor> findByAuthorsId(int authorId);

}
