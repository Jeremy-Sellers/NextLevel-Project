package com.personal.nextlevel.controller;

import com.personal.nextlevel.models.Barber;
import com.personal.nextlevel.repository.BarberRepository;
import com.personal.nextlevel.repository.DrinkRepository;
import com.personal.nextlevel.repository.ReviewRepository;
import com.personal.nextlevel.repository.ShopRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
}
