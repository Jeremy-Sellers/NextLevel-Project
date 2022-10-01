package com.personal.nextlevel.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
    @Table(name = "users")
    public class User {
        //FOr security reasons
        public User(User copy){
            id = copy.id;
            email = copy.email;
            username = copy.username;
            password = copy.password;
        }


        // Generate a key for id
        // Primary Key
        @Id
        @Column(name = "USER_ID", nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "FIRST_NAME",nullable = false, length = 30)
        private String firstName;

        @Column(name="LAST_NAME", nullable = false, length = 30)
        private String lastName;

        @Column(name="EMAIL",nullable = false, length = 100)
        private String email;

        // The Username is only max length at 15 characters
        @Column(name="USERNAME", nullable = false,unique = true, length = 16)
        private String username;

        // Password Max length is 15 characters


        @Column(name="PASSWORD", nullable = false, length = 100)
        private String password;

        @Column(name = "ADMIN")
        private boolean isAdmin;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "users_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id")
        )
        private Set<Roles> roles = new HashSet<>();

        public void addRole(Roles role) {
            this.roles.add(role);
        }

//----- Constructor Empty

        public User() {
        }

        //----- Constructor
        public User(long id, String firstName, String lastName, String email, String username, String password, boolean isAdmin) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.username = username;
            this.password = password;
            this.isAdmin = isAdmin;
        }


        //----- Getters and Setters
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean getIsAdmin() {
            return isAdmin;
        }

        public void setIsAdmin(boolean admin) {
            this.isAdmin = admin;
        }


        public Set<Roles> getRoles() {
            return roles;
        }

        public void setRoles(Set<Roles> roles) {
            this.roles = roles;
        }
}
