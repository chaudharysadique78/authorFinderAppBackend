package com.authorFinder.favorite_service.service;

import com.authorFinder.favorite_service.dto.FavouriteAuthorDTO;
import com.authorFinder.favorite_service.entity.Author;
import com.authorFinder.favorite_service.entity.FavouriteAuthor;
import com.authorFinder.favorite_service.entity.User;
import com.authorFinder.favorite_service.exception.AuthorNotFoundException;
import com.authorFinder.favorite_service.exception.CustomException;
import com.authorFinder.favorite_service.exception.NoFavouriteException;
import com.authorFinder.favorite_service.exception.UserNotFoundException;
import com.authorFinder.favorite_service.repo.AuthorRepo;
import com.authorFinder.favorite_service.repo.FavouriteAuthorRepo;
import com.authorFinder.favorite_service.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private FavouriteAuthorRepo favouriteAuthorRepo;

    @Override
    public FavouriteAuthor addFavourite(int userId, int authorId) {
        FavouriteAuthor favouriteAuthor = new FavouriteAuthor();
        User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException(String.valueOf(userId)));
        Author author = authorRepo.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(String.valueOf(authorId)));
        Optional<FavouriteAuthor> favAuthor = favouriteAuthorRepo.findById(userId);
        if (favAuthor.isPresent()) {
            favouriteAuthor = favAuthor.get();
            List<Author> authorlist = favouriteAuthor.getAuthor();
            CopyOnWriteArrayList list = new CopyOnWriteArrayList(authorlist);
            for (Author author1 : authorlist) {
                if (author1.getId() == authorId)
                    throw new CustomException("Author already added to favourite list with given id", String.valueOf(authorId));
            }
            list.add(author);
            favouriteAuthor.setAuthor(list);
        } else {
            favouriteAuthor.setId(userId);
            favouriteAuthor.setUserId(userId);
            favouriteAuthor.setAuthorsId(authorId);
            favouriteAuthor.setUserEmail(user.getEmail());
            favouriteAuthor.setAuthor(List.of(author));
        }
        return favouriteAuthorRepo.save(favouriteAuthor);
    }

    @Override
    public FavouriteAuthorDTO getFavouriteAuthor(int userId) {
        FavouriteAuthor favouriteAuthor = favouriteAuthorRepo.findById(userId).orElseThrow(() -> new NoFavouriteException(String.valueOf(userId)));
        return new FavouriteAuthorDTO(favouriteAuthor.getAuthor());
    }

    @Override
    public FavouriteAuthorDTO removeFavouriteAuthor(int userId, int authorId) {
        FavouriteAuthor favouriteAuthor = favouriteAuthorRepo.findById(userId).get();
        User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException(String.valueOf(userId)));
        Author author = authorRepo.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(String.valueOf(authorId)));
        Optional<FavouriteAuthor> favAuthor = favouriteAuthorRepo.findById(userId);
        if (favAuthor.isPresent()) {
            FavouriteAuthor favouriteAuthor1 = favAuthor.get();
            List<Author> authorlist = favouriteAuthor1.getAuthor();
            CopyOnWriteArrayList list = new CopyOnWriteArrayList(authorlist);
            int count = 0;
            for (Author author1 : authorlist) {
                if (author1.getId() == authorId) {
                    list.remove(author1);
                    favouriteAuthor.setAuthor(list);
                    favouriteAuthorRepo.save(favouriteAuthor);
                    count++;
                }
            }
            if (count > 0) {

            } else {
                throw new AuthorNotFoundException(String.valueOf(authorId));
            }

        }
        return new FavouriteAuthorDTO(favouriteAuthor.getAuthor());
    }

}
