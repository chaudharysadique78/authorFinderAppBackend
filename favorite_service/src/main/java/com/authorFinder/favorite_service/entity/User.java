package com.authorFinder.favorite_service.entity;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;
      @Column(unique = true,nullable = false)
      private String email;
      private String password;
      private String phone;
      private int age;

}
