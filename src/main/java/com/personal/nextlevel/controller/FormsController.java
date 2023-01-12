package com.personal.nextlevel.controller;

import com.personal.nextlevel.models.*;
import com.personal.nextlevel.repository.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
public class FormsController {
    private final BarberRepository barberDao;
    private final DrinkRepository drinkDao;
    private final ShopRepository shopDao;
    private final ReviewRepository reviewDao;
    private final PhotoRepository photoDao;
    private final UserRepository userDao;

    public FormsController(BarberRepository barberDao, DrinkRepository drinkDao, ShopRepository shopDao, ReviewRepository reviewDao, PhotoRepository photoDao, UserRepository userDao) {
        this.barberDao = barberDao;
        this.drinkDao = drinkDao;
        this.shopDao = shopDao;
        this.reviewDao = reviewDao;
        this.photoDao = photoDao;
        this.userDao = userDao;
    }

    @GetMapping("/Controls")
    public String showForms(Model model){
        model.addAttribute("barber", new Barber());
        model.addAttribute("barbers", barberDao.findAll());
        model.addAttribute("drink", new Drink());
        model.addAttribute("drinks", drinkDao.findAll());
        model.addAttribute("shop", shopDao.findById(1));
        model.addAttribute("photo", photoDao.findAll());
        model.addAttribute("users",userDao.findAll());
        model.addAttribute("review", new Review());
        model.addAttribute("reviews",reviewDao.findAll());
        return "home/forms";
    }

    @PostMapping("/Controls")
    public String addBarber(@ModelAttribute Barber barber,@RequestParam(name = "file") MultipartFile uploadedFile){
        barberDao.save(barber);

        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);
        try {
            uploadedFile.transferTo(destinationFile);
            Photo photo = new Photo();
            photo.setPhotoName(filename);
            photo.setBarber(barber);
            barber.setPhotoName(filename);
            photoDao.save(photo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";

    }

    @PostMapping("/Controls/addReview")
    public String addReview(@ModelAttribute Review review){
        reviewDao.save(review);
        return "redirect:/";
    }

    @PostMapping("/Controls/Delete")
    public String deleteBarber(@RequestParam(name = "deleteBarber") long id){
        barberDao.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/Controls/NewDrink")
    public String addDrink(@ModelAttribute Drink drink){
        drinkDao.save(drink);
        return "redirect:/";
    }

    @PostMapping("/Controls/DeleteDrink")
    public String deleteDrink(@RequestParam(name = "deleteDrink") long id){
        drinkDao.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/Controls/DeleteReview")
    public String deleteReview(@RequestParam(name = "deleteReview") long id){
        reviewDao.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/Controls/DeleteUser")
    public String deleteUser(@RequestParam(name = "deleteUser") long id){
        userDao.deleteById(id);
        return "redirect:/";
    }


    @PostMapping("/Controls/EditBarber")
    public String editBarberInfo(@ModelAttribute Barber barber, @RequestParam(name = "barberId") long id){
        Barber findBarber = barberDao.getById(id);
        findBarber.setBio(barber.getBio());
        findBarber.setFirstName(barber.getFirstName());
        findBarber.setLink(barber.getLink());

        barberDao.save(findBarber);
        return "redirect:/";
    }

    @PostMapping("/Controls/{id}")
    public String editInfo(@ModelAttribute Shop shop){
        Shop findShop = shopDao.findById(1);
        findShop.setShopHeading(shop.getShopHeading());
        findShop.setShopDescription(shop.getShopDescription());
        findShop.setShopMessageHeader(shop.getShopMessageHeader());
        findShop.setShopMessageDescription(shop.getShopMessageDescription());
        findShop.setShopAppointmentsDescription(shop.getShopAppointmentsDescription());
        findShop.setShopAddress(shop.getShopAddress());
        findShop.setFacebookLink(shop.getFacebookLink());
        findShop.setInstagramLink(shop.getInstagramLink());
        findShop.setMonOpen(shop.getMonOpen());
        findShop.setMonClose(shop.getMonClose());
        findShop.setTueOpen(shop.getTueOpen());
        findShop.setTueClose(shop.getTueClose());
        findShop.setWedOpen(shop.getWedOpen());
        findShop.setWedClose(shop.getWedClose());
        findShop.setThuOpen(shop.getThuOpen());
        findShop.setThuClose(shop.getThuClose());
        findShop.setFriOpen(shop.getFriOpen());
        findShop.setFriClose(shop.getFriClose());
        findShop.setSatOpen(shop.getSatOpen());
        findShop.setSatClose(shop.getSatClose());
        findShop.setSunOpen(shop.getSunOpen());
        findShop.setSunClose(shop.getSunClose());
        shopDao.save(findShop);
        return "redirect:/";
    }

    @Value("${file-upload-path}")
    private String uploadPath;

    @PostMapping("/fileupload")
    public String saveFile(
            @RequestParam(name = "file") MultipartFile uploadedFile,
            Model model, @RequestParam(name = "barber") long id
    ) {
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);
        try {
            uploadedFile.transferTo(destinationFile);
            Barber barberForImage = barberDao.getById(id);
            barberForImage.setPhotoName(filename);
            Photo photo = new Photo();
            photo.setPhotoName(filename);
            photo.setBarber(barberForImage);
            photoDao.save(photo);
            model.addAttribute("message", "File successfully uploaded!");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Oops! Something went wrong! " + e);
        }
        return "redirect:/";
    }

    @PostMapping("/shopImageUpload")
    public String uploadShopImage(@RequestParam(name = "file") MultipartFile uploadedFile){
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);
        try {
            uploadedFile.transferTo(destinationFile);
            Photo photo = new Photo();
            photo.setPhotoName(filename);
            Shop shop = shopDao.getById(1);
            shop.setShopPhotoName(filename);
            photo.setShop(shop);
            photoDao.save(photo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }

    @PostMapping("/shopDrinkUpload")
    public String uploadDrinkImage(@RequestParam(name = "file") MultipartFile uploadedFile){
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);
        try {
            uploadedFile.transferTo(destinationFile);
            Photo photo = new Photo();
            photo.setPhotoName(filename);
            Shop shop = shopDao.getById(1);
            shop.setDrinkPhotoName(filename);
            photo.setShop(shop);
            photoDao.save(photo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }

    @PostMapping("/shopDescriptionImageUpload")
    public String uploadShopDescriptionImage(@RequestParam(name = "file") MultipartFile uploadedFile){
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);
        try {
            uploadedFile.transferTo(destinationFile);
            Photo photo = new Photo();
            photo.setPhotoName(filename);
            Shop shop = shopDao.getById(1);
            shop.setShopDescriptionPhotoName(filename);
            photo.setShop(shop);
            photoDao.save(photo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }

    @PostMapping("/addShopPortfolioPhoto")
    public String addShopPortfolioPhoto(@RequestParam(name = "file") MultipartFile uploadedFile){
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);
        try {
            uploadedFile.transferTo(destinationFile);
            Photo photo = new Photo();
            photo.setPhotoName(filename);
            Shop shop = shopDao.getById(1);
            photo.setShop(shop);
            photoDao.save(photo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }

}
