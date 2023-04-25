package com.personal.nextlevel.repository;

import com.personal.nextlevel.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
//    User getById(Long id);
    User findAllByUsername(String username);
}
