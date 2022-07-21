package com.demo.hplus.restcontrollers;

import com.demo.hplus.exceptions.LoginFailureException;
import com.demo.hplus.models.Login;
import com.demo.hplus.models.User;
import com.demo.hplus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("hplus/api/v3/loginuser")
    public ResponseEntity loginUser(@RequestBody Login login) throws LoginFailureException {
        System.out.println(login.getUsername() + " " + login.getPassword());
        User user = userRepository.searchByUsername(login.getUsername());
        if(user == null){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);

        }

        if(user.getUsername().equals(login.getUsername()) && user.getPassword().equals(login.getPassword())){
            return new ResponseEntity<>("Welcome, "+login.getUsername(),HttpStatus.OK);
        }else {
            throw new LoginFailureException("Invalid username or password");
        }


    }
}
