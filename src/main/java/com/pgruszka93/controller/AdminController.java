package com.pgruszka93.controller;

import com.pgruszka93.entity.User;
import com.pgruszka93.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.AccessControlException;
import java.util.Collection;

@Controller
@RequestMapping("/adminPanel")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAdminPanel(Model theModel) {

        Collection<User> users = userService.findAllUsers();
        theModel.addAttribute("users", users);


        return "admin-panel";
    }

    @GetMapping("/changeEnabledStatus")
    public String changeEnabledStatus(@RequestParam("userId") long userId){
        System.out.println("Change enabled status button clicked");

        try{
            userService.changeEnableStatus(userId);
        } catch (AccessControlException e){
            return "access-denied";
        }
        return "redirect:/adminPanel/";

    }
}
