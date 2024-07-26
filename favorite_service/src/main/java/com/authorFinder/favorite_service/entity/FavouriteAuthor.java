package com.authorFinder.favorite_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class FavouriteAuthor {

    @Id
    private int id;
    private int userId;
    private String userEmail;
    private int authorsId;
    @ManyToMany
    private List<Author> author;

}
