package com.demo.hplus.controllers;

import com.demo.hplus.exceptions.ApplicationException;
import com.demo.hplus.models.Login;
import com.demo.hplus.models.User;
import com.demo.hplus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@ModelAttribute("login")Login login){
        System.out.println("in login controller");
        User user = userRepository.searchByUsername(login.getUsername());
        if( user == null){
            throw new ApplicationException("User not found");
        }
        return "search";
    }

   /*
    Move to global exception handler
   @ExceptionHandler(ApplicationException.class)
    public String handleException(){
        System.out.println("in exception handler login contro");
        return "error";
    }
    */
}
