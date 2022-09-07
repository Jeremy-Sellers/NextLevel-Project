package com.personal.nextlevel.controller;

import com.personal.nextlevel.repository.BarberRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final BarberRepository barberDao;

    public HomeController(BarberRepository barberDao) {
        this.barberDao = barberDao;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("barbers", barberDao.findAll());
        return "home/home";
    }
}
