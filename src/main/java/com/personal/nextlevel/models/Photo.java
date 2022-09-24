package com.personal.nextlevel.models;

import javax.persistence.*;


@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String photoName;

    private String photoType;

    private byte[] picByte;

    @ManyToOne
    @JoinColumn (name = "barber_id")
    private Barber barber;

    public Photo(){}

    public Photo(String photoName, String photoType, byte[] picByte, Barber barber) {
        this.photoName = photoName;
        this.photoType = photoType;
        this.picByte = picByte;
        this.barber = barber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }

    public Barber getBarber() {
        return barber;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }
}
