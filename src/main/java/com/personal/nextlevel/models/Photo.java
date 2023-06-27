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

    private String photoUrl;

    private String shopPortfolioImageUrl;

    private String barberPortfolioUrl;

    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public Photo(){}

    public Photo(Long id, String photoName, String photoType, byte[] picByte, Barber barber, Shop shop, String photoUrl, String shopPortfolioImageUrl, String barberPortfolioUrl) {
        this.id = id;
        this.photoName = photoName;
        this.photoType = photoType;
        this.picByte = picByte;
        this.barber = barber;
        this.shop = shop;
        this.photoUrl = photoUrl;
        this.shopPortfolioImageUrl = shopPortfolioImageUrl;
        this.barberPortfolioUrl = barberPortfolioUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getShopPortfolioImageUrl() {
        return shopPortfolioImageUrl;
    }

    public void setShopPortfolioImageUrl(String shopPortfolioImageUrl) {
        this.shopPortfolioImageUrl = shopPortfolioImageUrl;
    }

    public String getBarberPortfolioUrl() {
        return barberPortfolioUrl;
    }

    public void setBarberPortfolioUrl(String barberPortfolioUrl) {
        this.barberPortfolioUrl = barberPortfolioUrl;
    }
}
