package com.personal.nextlevel.controller;

import com.personal.nextlevel.models.*;
import com.personal.nextlevel.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;



@Controller
public class FormsController {
    private final BarberRepository barberDao;
    private final DrinkRepository drinkDao;
    private final ShopRepository shopDao;
    private final ReviewRepository reviewDao;
    private final PhotoRepository photoDao;
    private final UserRepository userDao;
    private final ServiceRepository serviceDao;
    @Autowired
    private ResourceLoader resourceLoader;


    public FormsController(BarberRepository barberDao, DrinkRepository drinkDao, ShopRepository shopDao, ReviewRepository reviewDao, PhotoRepository photoDao, UserRepository userDao, ServiceRepository serviceDao) {
        this.barberDao = barberDao;
        this.drinkDao = drinkDao;
        this.shopDao = shopDao;
        this.reviewDao = reviewDao;
        this.photoDao = photoDao;
        this.userDao = userDao;
        this.serviceDao = serviceDao;
    }

    @GetMapping("/Controls")
    public String showForms(Model model){
        model.addAttribute("barber", new Barber());
        model.addAttribute("barbers", barberDao.findAll());
        model.addAttribute("drink", new Drink());
        model.addAttribute("drinks", drinkDao.findAll());
        model.addAttribute("shop", shopDao.findById(1));
        model.addAttribute("photo", photoDao.findAll());
        model.addAttribute("barberPhotos",photoDao.findAll());
        model.addAttribute("users",userDao.findAll());
        model.addAttribute("review", new Review());
        model.addAttribute("reviews",reviewDao.findAll());
        model.addAttribute("services", serviceDao.findAll());
        model.addAttribute("service", new Service());
        return "home/forms";
    }

//    @PostMapping("/Controls")
//    public String addBarber(@ModelAttribute Barber barber,@RequestParam(name = "file") MultipartFile uploadedFile){
//        barberDao.save(barber);
//
//        String filename = uploadedFile.getOriginalFilename();
//        String filepath = Paths.get(uploadPath, filename).toString();
//        File destinationFile = new File(filepath);
//        try {
//            uploadedFile.transferTo(destinationFile);
//            Photo photo = new Photo();
//            photo.setPhotoName(filename);
//            photo.setBarber(barber);
//            barber.setPhotoName(filename);
//            photoDao.save(photo);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "redirect:/";
//    }
@PostMapping("/Controls")
public String addBarber(@ModelAttribute Barber barber, @RequestParam(name = "photoUrl3") String photoUrl3) {
    barberDao.save(barber);

    try {
        Photo photo = new Photo();
        photo.setPhotoUrl(photoUrl3);
        photo.setBarber(barber);
        barber.setPhotoUrl(photoUrl3);
        photoDao.save(photo);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "redirect:/";
}


    @PostMapping("/Controls/addReview")
    public String addReview(@ModelAttribute Review review){
        reviewDao.save(review);
        return "redirect:/";
    }

    @PostMapping("/addService")
    public String addService(@ModelAttribute Service service){
        serviceDao.save(service);
        return "redirect:/";
    }

    @PostMapping("/deleteService")
    public String deleteService(@RequestParam(name = "deleteService") long id){
        serviceDao.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/deleteBarberPortfolioPhoto")
    public String deleteBarberPortfolio(@RequestParam(name = "deleteBarberPortfolio") long id){
        photoDao.deleteById(id);
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
        findShop.setShopTeleNum(shop.getShopTeleNum());
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


    private String uploadPath = "static/images";

    @PostMapping("/fileupload")
    public String saveFile(
            @RequestParam(name = "photoUrl") String photoUrl,
            Model model, @RequestParam(name = "barber") long id
    ) {
        try {
            Barber barberForImage = barberDao.getById(id);
            barberForImage.setPhotoUrl(photoUrl);
            Photo photo = new Photo();
            photo.setPhotoUrl(photoUrl);
            photo.setBarber(barberForImage);
            photoDao.save(photo);
            model.addAttribute("message", "File successfully uploaded!");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Oops! Something went wrong! " + e);
        }
        return "redirect:/";
    }

    @PostMapping("/shopImageUpload")
    public String uploadShopImage(@RequestParam(name = "photoUrl2")  String photoUrl2){
        try {
            Photo photo = new Photo();
            photo.setPhotoUrl(photoUrl2);
            Shop shop = shopDao.getById(1);
            shop.setShopPhotoUrl(photoUrl2);
            photo.setShop(shop);
            photoDao.save(photo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }

    @PostMapping("/barberPortfolioUpload")
    public String uploadBarberPortfolio(@RequestParam(name = "photoUrl5") String photoUrl5,@RequestParam(name = "barber2") long id){
        try {
            Barber barber = barberDao.getById(id);
            Photo photo = new Photo();
            photo.setBarberPortfolioUrl(photoUrl5);
            photo.setBarber(barber);
            photoDao.save(photo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }

//    @PostMapping("/shopDrinkUpload")
//    public String uploadDrinkImage(@RequestParam(name = "photoUrl4") String photoUrl4){
//        try {
//            Photo photo = new Photo();
//            photo.setPhotoUrl(photoUrl4);
//            Shop shop = shopDao.getById(1);
//            shop.setShopDrinkPhotoUrl(photoUrl4);
//            photo.setShop(shop);
//            photoDao.save(photo);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return "redirect:/";
//    }

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
    public String addShopPortfolioPhoto(@RequestParam(name = "photoUrl4")  String photoUrl4){
        try {
            Photo photo = new Photo();
            photo.setShopPortfolioImageUrl(photoUrl4);
            Shop shop = shopDao.getById(1);
            photo.setShop(shop);
            photoDao.save(photo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/Controls";
    }

    @PostMapping("/deleteShopPortfolioPhoto")
    public String deleteShopPortfolioPhoto(@RequestParam(name = "deletePhoto") long id){
        photoDao.deleteById(id);
        return "redirect:/";
    }

}
