package com.demo.hplus.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {

    @GetMapping("/home")
    public String shigaGida(){
        System.out.println("ina gidan controller");
        return "index";
    }
}
