package com.personal.nextlevel.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String shopHeading;

    private String shopDescription;

    private String shopTeleNum;

    private String shopAddress;

    private String instagramLink;

    private String facebookLink;

    private String monOpen;
    private String monClose;

    private String tueOpen;
    private String tueClose;

    private String wedOpen;
    private String wedClose;

    private String thuOpen;
    private String thuClose;

    private String friOpen;
    private String friClose;

    private String satOpen;
    private String satClose;

    private String sunOpen;
    private String sunClose;

    private String drinkPhotoName;

    private String shopPhotoName;

    private String shopDescriptionPhotoName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shop")
    private List<Photo> photos;

    public Shop() {
    }


    public Shop(long id, String shopHeading, String shopDescription, String shopTeleNum, String shopAddress, String monOpen, String monClose, String tueOpen, String tueClose, String wedOpen, String wedClose, String thuOpen, String thuClose, String friOpen, String friClose, String satOpen, String satClose, String sunOpen, String sunClose, List<Photo> photos, String drinkPhotoName, String shopPhotoName, String shopDescriptionPhotoName,String instagramLink, String facebookLink ) {
        this.id = id;
        this.shopHeading = shopHeading;
        this.shopDescription = shopDescription;
        this.shopTeleNum = shopTeleNum;
        this.shopAddress = shopAddress;
        this.monOpen = monOpen;
        this.monClose = monClose;
        this.tueOpen = tueOpen;
        this.tueClose = tueClose;
        this.wedOpen = wedOpen;
        this.wedClose = wedClose;
        this.thuOpen = thuOpen;
        this.thuClose = thuClose;
        this.friOpen = friOpen;
        this.friClose = friClose;
        this.satOpen = satOpen;
        this.satClose = satClose;
        this.sunOpen = sunOpen;
        this.sunClose = sunClose;
        this.photos = photos;
        this.drinkPhotoName = drinkPhotoName;
        this.shopPhotoName = shopPhotoName;
        this.shopDescriptionPhotoName = shopDescriptionPhotoName;
        this.instagramLink = instagramLink;
        this.facebookLink = facebookLink;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShopHeading() {
        return shopHeading;
    }

    public void setShopHeading(String shopHeading) {
        this.shopHeading = shopHeading;
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    public String getShopTeleNum() {
        return shopTeleNum;
    }

    public void setShopTeleNum(String shopTeleNum) {
        this.shopTeleNum = shopTeleNum;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getInstagramLink() {
        return instagramLink;
    }

    public void setInstagramLink(String instagramLink) {
        this.instagramLink = instagramLink;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getMonOpen() {
        return monOpen;
    }

    public void setMonOpen(String monOpen) {
        this.monOpen = monOpen;
    }

    public String getMonClose() {
        return monClose;
    }

    public void setMonClose(String monClose) {
        this.monClose = monClose;
    }

    public String getTueOpen() {
        return tueOpen;
    }

    public void setTueOpen(String tueOpen) {
        this.tueOpen = tueOpen;
    }

    public String getTueClose() {
        return tueClose;
    }

    public void setTueClose(String tueClose) {
        this.tueClose = tueClose;
    }

    public String getWedOpen() {
        return wedOpen;
    }

    public void setWedOpen(String wedOpen) {
        this.wedOpen = wedOpen;
    }

    public String getWedClose() {
        return wedClose;
    }

    public void setWedClose(String wedClose) {
        this.wedClose = wedClose;
    }

    public String getThuOpen() {
        return thuOpen;
    }

    public void setThuOpen(String thuOpen) {
        this.thuOpen = thuOpen;
    }

    public String getThuClose() {
        return thuClose;
    }

    public void setThuClose(String thuClose) {
        this.thuClose = thuClose;
    }

    public String getFriOpen() {
        return friOpen;
    }

    public void setFriOpen(String friOpen) {
        this.friOpen = friOpen;
    }

    public String getFriClose() {
        return friClose;
    }

    public void setFriClose(String friClose) {
        this.friClose = friClose;
    }

    public String getSatOpen() {
        return satOpen;
    }

    public void setSatOpen(String satOpen) {
        this.satOpen = satOpen;
    }

    public String getSatClose() {
        return satClose;
    }

    public void setSatClose(String satClose) {
        this.satClose = satClose;
    }

    public String getSunOpen() {
        return sunOpen;
    }

    public void setSunOpen(String sunOpen) {
        this.sunOpen = sunOpen;
    }

    public String getSunClose() {
        return sunClose;
    }

    public void setSunClose(String sunClose) {
        this.sunClose = sunClose;
    }

    public String getDrinkPhotoName() {
        return drinkPhotoName;
    }

    public void setDrinkPhotoName(String drinkPhotoName) {
        this.drinkPhotoName = drinkPhotoName;
    }

    public String getShopPhotoName() {
        return shopPhotoName;
    }

    public void setShopPhotoName(String shopPhotoName) {
        this.shopPhotoName = shopPhotoName;
    }

    public String getShopDescriptionPhotoName() {
        return shopDescriptionPhotoName;
    }

    public void setShopDescriptionPhotoName(String shopDescriptionPhotoName) {
        this.shopDescriptionPhotoName = shopDescriptionPhotoName;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
