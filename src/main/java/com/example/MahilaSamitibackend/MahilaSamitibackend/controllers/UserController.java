package com.example.MahilaSamitibackend.MahilaSamitibackend.controllers;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.User;
import com.example.MahilaSamitibackend.MahilaSamitibackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/home")
    public String home(){
        return "This is home page";
    }

    @GetMapping("/users")
    public List<User> getCourse(){
        return userService.getUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable String userId){
        Optional<User> user = userService.getUser(Long.parseLong(userId));
        return user.get();
    }

    @PostMapping("/user")
    public User createCourse(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/user")
    public User updateCourse(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId){
        try{
            userService.deleteUser(Long.parseLong(userId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
