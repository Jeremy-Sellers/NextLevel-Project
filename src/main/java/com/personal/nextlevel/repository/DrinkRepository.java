package com.personal.nextlevel.repository;

import com.personal.nextlevel.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    Drink findByDrinkName(String drinkName);
    Drink findById(long id);
}
