package com.processes.shop.service;

import com.processes.shop.model.Address;
import com.processes.shop.model.User;
import com.processes.shop.model.enums.DocumentType;
import com.processes.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User updateUser(User userUpdated, Long id) {

        Optional<User> userBd = userRepository.findById(id);
        if (userBd.isEmpty()){
            return null;
        }
        userBd.get().setFullName(userUpdated.getFullName());
        userBd.get().setPhoneNumber(userUpdated.getPhoneNumber());
        return userRepository.save(userBd.get());
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            return null;
        }
        return user.get();
    }

    @Override
    public List<User> findAllUsers() {

        return (List<User>) userRepository.findAll();
    }
}
