package com.personal.nextlevel.controller;

import com.personal.nextlevel.models.Barber;
import com.personal.nextlevel.models.Drink;
import com.personal.nextlevel.models.Shop;
import com.personal.nextlevel.repository.BarberRepository;
import com.personal.nextlevel.repository.DrinkRepository;
import com.personal.nextlevel.repository.ReviewRepository;
import com.personal.nextlevel.repository.ShopRepository;
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

    public FormsController(BarberRepository barberDao, DrinkRepository drinkDao, ShopRepository shopDao, ReviewRepository reviewDao) {
        this.barberDao = barberDao;
        this.drinkDao = drinkDao;
        this.shopDao = shopDao;
        this.reviewDao = reviewDao;
    }

    @GetMapping("/Controls")
    public String registerBarber(Model model){
        model.addAttribute("barber", new Barber());
        model.addAttribute("barbers", barberDao.findAll());
        model.addAttribute("drink", new Drink());
        model.addAttribute("drinks", drinkDao.findAll());
        model.addAttribute("shop", shopDao.findById(1));
        return "home/forms";
    }

    @PostMapping("/Controls")
    public String addBarber(@ModelAttribute Barber barber){
        barberDao.save(barber);
        return "home/forms";
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

    @PostMapping("/Controls/{id}")
    public String editInfo(@ModelAttribute Shop shop){
        Shop findShop = shopDao.findById(1);
        findShop.setShopHeading(shop.getShopHeading());
        findShop.setShopDescription(shop.getShopDescription());
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
            @RequestParam(name = "file") MultipartFile uploadedFile
    ) {
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);
        try {
            uploadedFile.transferTo(destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "home/forms";
    }
}
