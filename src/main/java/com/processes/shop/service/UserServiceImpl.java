package com.processes.shop.service;

import com.processes.shop.model.Address;
import com.processes.shop.model.User;
import com.processes.shop.model.enums.DocumentType;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
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
        return User.builder()
                .fullName("Pepito perez")
                .document("123")
                .documentType(DocumentType.CC)
                .address(
                        List.of(
                            Address.builder()
                                .avenue("1212")
                                .neighborhood("12131")
                                .build(),

                                Address.builder()
                                        .avenue("123")
                                        .neighborhood("321")
                                        .build()

                        )

                )
                .build();
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }
}
