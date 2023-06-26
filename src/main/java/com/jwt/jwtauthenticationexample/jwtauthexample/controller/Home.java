package com.jwt.jwtauthenticationexample.jwtauthexample.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Home {
    @GetMapping("/welcome")
    public String welcome(){
        String text="This is private page";
        text+="This is for the authenticated users";
        return text;
    }
    @GetMapping("/getUsers")
    public String getUsers(){
        return "{'name':'durgesh','age':'30'}";
    }
}
