package com.lostfound.lostfound.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lostfound.lostfound.model.User;
import com.lostfound.lostfound.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


     public User createUser(User user){
        return userRepository.save(user);
     }
   
    public boolean isUsernameTaken(String username) {
        return userRepository.findByUsername(username) != null;
    }
    

    public List<User> getUsersById(Long id){
        return userRepository.findAllById(List.of(id));
    }

    public boolean isEmailTaken(String email) {
        return userRepository.findByEmail(email) != null;
    }

public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public String getUserPassword(String username) {
       
        User user = userRepository.findByUsername(username);
        return user != null ? user.getPassword() : null;
    }



    public void saveUser(com.lostfound.lostfound.model.User user) {
        userRepository.save(user);
    }



     public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
   
    

    
}
