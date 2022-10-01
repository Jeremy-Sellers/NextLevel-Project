package com.personal.nextlevel.repository;

import com.personal.nextlevel.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
Roles findByName(String name);
}
