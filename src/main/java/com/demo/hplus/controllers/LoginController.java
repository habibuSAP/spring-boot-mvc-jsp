package com.demo.hplus.controllers;

import com.demo.hplus.exceptions.ApplicationException;
import com.demo.hplus.models.Login;
import com.demo.hplus.models.User;
import com.demo.hplus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@ModelAttribute("login")Login login, HttpSession httpSession){

        httpSession.setMaxInactiveInterval(5000);
        System.out.println("in login controller");
        User user = userRepository.searchByUsername(login.getUsername());
        if( user == null){
            throw new ApplicationException("User not found");
        }
        return "forward:/userprofile";
    }

   @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
//       System.out.println("Verify the user session " + httpSession.getAttribute("login"));
       return "login";
   }
}
