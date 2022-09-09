package com.personal.nextlevel.models;

import javax.persistence.*;

@Entity
@Table(name = "drinks")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String drinkName;

    public Drink(){}

    public Drink(Long id, String drinkName) {
        this.id = id;
        this.drinkName = drinkName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }
}
