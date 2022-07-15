package com.demo.hplus.exceptions;

import com.demo.hplus.models.Login;
import com.demo.hplus.models.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice

public class ApplicationExceptionGlobalController {

    @ExceptionHandler({ApplicationException.class, AsyncRequestTimeoutException.class})
    public String handleException(){
        System.out.println("in global exception handler controller");
        return "error";
    }

    @ModelAttribute("newuser")
    public User getDefaultUser(){
        return new User();
    }

    @ModelAttribute("login")
    public Login getDefaultLogin(){
        return new Login();
    }

    @ModelAttribute("genderItems")
    public List<String> getGenderItems(){
        return Arrays.asList(new String[]{"Male", "Female"});
    }
}
