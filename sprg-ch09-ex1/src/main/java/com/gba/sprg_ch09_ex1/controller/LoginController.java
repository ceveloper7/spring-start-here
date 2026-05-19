package com.gba.sprg_ch09_ex1.controller;

import com.gba.sprg_ch09_ex1.processor.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor){
        this.loginProcessor = loginProcessor;
    }

    // root path
    @GetMapping("/")
    public String loginGet(){
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ){
        boolean loggedIn = false;

        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        loggedIn = loginProcessor.login();

        if (loggedIn){
            model.addAttribute("message", "You are logged in.");
        }else{
            model.addAttribute("message", "Login failed");
        }

        return "login.html";
    }
}
