package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getUsers();
    public Optional<User> getUser(Long id);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(long courseId);
}

