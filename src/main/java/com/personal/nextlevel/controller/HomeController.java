package com.personal.nextlevel.controller;

import com.personal.nextlevel.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final BarberRepository barberDao;
    private final DrinkRepository drinkDao;
    private final ShopRepository shopDao;
    private final ReviewRepository reviewDao;
    private final PhotoRepository photoDao;
    private final ServiceRepository serviceDao;

    public HomeController(BarberRepository barberDao, DrinkRepository drinkDao, ShopRepository shopDao, ReviewRepository reviewDao, PhotoRepository photoDao, ServiceRepository serviceDao) {
        this.barberDao = barberDao;
        this.drinkDao = drinkDao;
        this.shopDao = shopDao;
        this.reviewDao = reviewDao;
        this.photoDao = photoDao;
        this.serviceDao = serviceDao;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("barbers", barberDao.findAll());
        model.addAttribute("drinks", drinkDao.findAll());
        model.addAttribute("shops", shopDao.findById(1));
        model.addAttribute("reviews", reviewDao.findAll());
        model.addAttribute("photos", photoDao.findAllByShop(shopDao.getById(1)));
        model.addAttribute("barberPhotos",photoDao.findAll());
        model.addAttribute("services", serviceDao.findAll());
        return "home/home";
    }
}
