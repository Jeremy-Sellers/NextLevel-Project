package com.personal.nextlevel.models;

import javax.persistence.*;
import java.util.*;

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

        private String roles = "";

        private String permissions = "";

//----- Constructor Empty

        public User() {
        }

        //----- Constructor
        public User(long id, String firstName, String lastName, String email, String username, String password, String roles, String permissions) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.username = username;
            this.password = password;
            this.roles = roles;
            this.permissions = permissions;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public List<String> getRoleList(){
            if (this.roles.length() > 0){
                return Arrays.asList(this.roles.split(","));
            }
            return new ArrayList<>();
    }

    public List<String> getPermissionList(){
        if (this.permissions.length() > 0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}
