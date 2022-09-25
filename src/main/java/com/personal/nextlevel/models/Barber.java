package com.personal.nextlevel.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "barbers")
public class Barber {

    @Id
    @Column(name = "barber_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 30)
    private String firstName;

    @Column(length = 30)
    private String lastName;

    @Column(length = 100)
    private String email;

    @Column(length = 250)
    private String bio;

    @Column()
    private String link;

    @Column
    private String photoName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "barber")
    private List<Photo> photos;

    public Barber(){}

    public Barber(long id, String firstName, String lastName, String email, String bio, String link, List<Photo> photos, String photoName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bio = bio;
        this.link = link;
        this.photos = photos;
        this.photoName = photoName;
    }

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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
