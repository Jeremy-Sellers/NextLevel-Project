package com.personal.nextlevel.repository;

import com.personal.nextlevel.models.Role;
import com.personal.nextlevel.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import javax.persistence.Table;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private RoleRepository roleRepo;
//    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("test@test.com");
        user.setUsername("Jdizzle");
        user.setPassword("Password1");

//        User existingUser = entityManager.find(User.class, savedUser.getId());
    }

    @Test
    public void testAddRoleToNewUser(){
        User user = new User();
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setEmail("Jane@test.com");
        user.setUsername("Jdazzle");
        user.setPassword("Password1");

        Role roleUser = roleRepo.findByName("User");

        User savedUser = repo.save(user);
    }

    @Test
    public void testAddRoleToExistingUser(){
        User existingUser = repo.findById(1L).get();
        Role roleAdmin = roleRepo.findByName("ADMIN");
    }
}
