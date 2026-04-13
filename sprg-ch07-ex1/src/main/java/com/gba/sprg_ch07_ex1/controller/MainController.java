package com.gba.sprg_ch07_ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String getHome(){
        return "home.html";
    }

}
