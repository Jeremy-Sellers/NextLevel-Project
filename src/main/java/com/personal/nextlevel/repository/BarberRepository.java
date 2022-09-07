package com.personal.nextlevel.repository;

import com.personal.nextlevel.models.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber, Long> {
    Barber findByFirstName(String firstName);
    Barber getById(Long id);
}
