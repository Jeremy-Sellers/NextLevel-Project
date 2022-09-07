package com.personal.nextlevel.models;

import javax.persistence.*;

@Entity
@Table(name = "barbers")
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "FIRST_NAME",nullable = false, length = 30)
    private String firstName;

    @Column(name="LAST_NAME", nullable = false, length = 30)
    private String lastName;

    @Column(name="EMAIL",nullable = false, length = 100)
    private String email;

    @Column(name="BIO", nullable = true, length = 250)
    private String bio;
}
