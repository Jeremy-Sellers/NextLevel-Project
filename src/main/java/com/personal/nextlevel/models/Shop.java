package com.personal.nextlevel.models;
import javax.persistence.*;

@Entity
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String shopDescription;

    private String shopTeleNum;

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

    public Shop() {
    }

    public Shop(long id, String shopDescription, String shopTeleNum, String monOpen, String monClose, String tueOpen, String tueClose, String wedOpen, String wedClose, String thuOpen, String thuClose, String friOpen, String friClose, String satOpen, String satClose, String sunOpen, String sunClose) {
        this.id = id;
        this.shopDescription = shopDescription;
        this.shopTeleNum = shopTeleNum;
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
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}