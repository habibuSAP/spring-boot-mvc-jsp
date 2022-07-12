package com.demo.hplus.controllers;


import com.demo.hplus.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class HomeController {

    @GetMapping("/home")
    public String goToHome(){
        System.out.println("ina gidan controller");
        return "index";
    }

    @GetMapping("/goToSearch")
    public String goToSearch(){
        System.out.println("going to search page");
        return "search";
    }

    @GetMapping("/goToLogin")
    public String goToLogin(){
        System.out.println("going to login page");
        return "login";
    }

    @GetMapping("/goToRegistration")
    public String goToRegistration() {
        System.out.println("going to registration page");
        return "register";
    }

    @ModelAttribute("newuser")
    public User getDefaultUser(){
        return new User();
    }

    @ModelAttribute("genderItems")
    public List<String> getGenderItems(){
        return Arrays.asList(new String[]{"Male", "Female"});
    }
}
