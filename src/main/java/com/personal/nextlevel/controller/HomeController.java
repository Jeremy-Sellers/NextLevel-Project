package com.personal.nextlevel.controller;

import com.personal.nextlevel.repository.BarberRepository;
import com.personal.nextlevel.repository.DrinkRepository;
import com.personal.nextlevel.repository.ReviewRepository;
import com.personal.nextlevel.repository.ShopRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final BarberRepository barberDao;
    private final DrinkRepository drinkDao;
    private final ShopRepository shopDao;
    private final ReviewRepository reviewDao;

    public HomeController(BarberRepository barberDao, DrinkRepository drinkDao, ShopRepository shopDao, ReviewRepository reviewDao) {
        this.barberDao = barberDao;
        this.drinkDao = drinkDao;
        this.shopDao = shopDao;
        this.reviewDao = reviewDao;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("barbers", barberDao.findAll());
        model.addAttribute("drinks", drinkDao.findAll());
        model.addAttribute("shops", shopDao.findById(1));
        model.addAttribute("reviews", reviewDao.findAll());
        return "home/home";
    }
}
