package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUser(Long id);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(long courseId);
}

