package com.example.java_crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user_details")
@Getter
@Setter
public class User {

    @Id
    private int id;

    private String username;

    private String password;

    private String email;
}