package com.demo.hplus.controllers;

import com.demo.hplus.models.User;
import com.demo.hplus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/registeruser")
    public String registerUser(@ModelAttribute("newuser") User user, Model model){
        System.out.println("in register controller");
        userRepository.save(user);
        model.addAttribute("dataSaved", "User registered successfully!");

        return "login";
    }
}
