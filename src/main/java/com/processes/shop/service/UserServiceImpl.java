package com.processes.shop.service;

import com.processes.shop.model.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User userUpdated, Long id) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return new User();
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }
}
