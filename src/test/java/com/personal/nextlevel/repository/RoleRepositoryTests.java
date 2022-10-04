package com.personal.nextlevel.repository;

import com.personal.nextlevel.models.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

    @Autowired RoleRepository repo;

    @Test
    public void testCreateRoles() {
        Role user = new Role("USER");
        Role admin = new Role("ADMIN");

        repo.saveAll(List.of(user, admin));

        List<Role> listRoles = repo.findAll();

        assert listRoles.contains(admin);
        assert listRoles.contains(user);

    }
}
