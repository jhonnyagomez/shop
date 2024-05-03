package com.processes.shop.repository;

import com.processes.shop.model.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findByBirthday(LocalDate birthday);
    Optional<User> findByEmailAndIdNot(String email, Long id);
}
