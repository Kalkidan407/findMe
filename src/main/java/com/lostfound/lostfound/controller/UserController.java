package com.lostfound.lostfound.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lostfound.lostfound.model.User;
import com.lostfound.lostfound.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    // User-related endpoints can be added here

    private final UserService userService;


  @PostMapping
  public User createUser(@RequestBody User user){
    return userService.createUser(user);
  }


   @GetMapping
   public List<User> getAlUsers() {
       return userService.getAllUser();
   }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUsersById(id)
                .stream().findFirst().orElseThrow(() -> new RuntimeException("User not found with id: " + id))
               ;
    }

    @GetMapping("/{name}")
    public User isUserNameTakenUser(@PathVariable String name) {
        return userService.isUsernameTaken(name) ? userService.getUserByUsername(name) :
        userService.getUserByUsername(name);

    }

    public String helloUser() {
        return "Hello, User!";
    }
    
   

    
    
}
