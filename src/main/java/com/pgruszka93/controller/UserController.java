package com.pgruszka93.controller;


import com.pgruszka93.entity.Recipe;
import com.pgruszka93.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Collection;


@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/userInfo")
    public String showUserInfo(Model model){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();

        org.springframework.security.core.userdetails.User user= (org.springframework.security.core.userdetails.User) auth.getPrincipal();
        String userName = user.getUsername();

        Collection<Recipe> recipes = userService.loadRecipesByUsername(userName);

        model.addAttribute("recipes", recipes);

        return "user-info";
    }



}
