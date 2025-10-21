package com.lostfound.lostfound.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "items")
public class Item {

    @Id
    private String id;
    private String name;
    private String description;
    private String locationFound;
    private String photoUrl;
    private boolean claimed;

    // Constructors, Getters, and Setters
}
