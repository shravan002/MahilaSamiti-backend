package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.dao.UserDao;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User createUser(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUser(Long userId) {
        return userDao.findById(userId).get();
    }


    @Override
    public User updateUser(User user) {
        return userDao.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = getUser(userId);
        userDao.delete(user);
    }
}

