package com.pgruszka93.controller;

import com.pgruszka93.dao.UserDao;
import com.pgruszka93.entity.User;
import com.pgruszka93.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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




}
