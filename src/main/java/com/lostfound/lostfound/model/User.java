package com.lostfound.lostfound.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
     private String role;

    // private boolean verified;
    // private String verificationToken;
    // private String resetToken;
    // private Long tokenExpiry;
    // private String profilePictureUrl;
    // private String phoneNumber;
    // private String address;
    // private String fullName;
    // private String bio;
    // private String socialMediaLinks;
    // private String preferences;

}
