package com.processes.shop.service;

import com.processes.shop.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User userUpdated, Long id);
    User getUserById(Long id);
    List<User> findAllUsers();
}
