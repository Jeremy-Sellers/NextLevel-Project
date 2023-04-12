package com.personal.nextlevel.controller;

import com.personal.nextlevel.models.Role;
import com.personal.nextlevel.models.User;
import com.personal.nextlevel.repository.RoleRepository;
import com.personal.nextlevel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleDao;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder, RoleRepository roleDao) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.roleDao = roleDao;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @Value("${admin-pass}")
    private String APass;

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user, @RequestParam(name = "admin") String adminPass){
        String AdminPassCheck = APass;
        if (adminPass.equals(AdminPassCheck)){
            user.setRoles("ADMIN");
        } else {
            user.setRoles("USER");
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/";
    }
}