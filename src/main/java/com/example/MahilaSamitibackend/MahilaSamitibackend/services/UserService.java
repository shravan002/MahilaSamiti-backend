package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getUsers();
    public Optional<User> getUser(Long id);

    public User createUser(User user);

    public User updateUser(User user);

    public void deleteUser(long courseId);
}

