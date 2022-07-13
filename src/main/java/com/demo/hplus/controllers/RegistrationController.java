package com.demo.hplus.controllers;

import com.demo.hplus.models.User;
import com.demo.hplus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(
                Date.class, "dateOfBirth", new CustomDateEditor(
                        new SimpleDateFormat("yyyy-MM-dd"), true
                )
        );

    }

    @PostMapping("/registeruser")
    public String registerUser(@Valid @ModelAttribute("newuser") User user, BindingResult bindingResult, Model model){
        System.out.println("in register controller");

        if(bindingResult.hasErrors()){ return "register"; }

        userRepository.save(user);
        model.addAttribute("dataSaved", "User registered successfully!");

        return "login";
    }
}
