package com.pgruszka93.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {

    @GetMapping("/recipes/recipeForm")
    public String showRecipeForm(){
        return "recipe-form";
    }



}
