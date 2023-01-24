package com.personal.nextlevel.repository;

import com.personal.nextlevel.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Long> {
    Service findById(long id);
}
