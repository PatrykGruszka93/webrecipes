package com.pgruszka93.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class UserController {

    @GetMapping("/userInfo")
    public String showUserInfo(Model model){

        return "user-info";
    }

}
