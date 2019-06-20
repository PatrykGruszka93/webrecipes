package com.pgruszka93.controller;


import com.pgruszka93.entity.Recipe;
import com.pgruszka93.model.RecipeModel;
import com.pgruszka93.service.RecipeService;
import com.pgruszka93.user.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/addRecipeForm")
    public String showRecipeForm(Model theModel){
        Recipe theRecipe = new Recipe();
        theModel.addAttribute("recipeModel", theRecipe);
        theModel.addAttribute("buttonText", "Dodaj");
        return "recipe-form";
    }

    @GetMapping("/updateRecipeForm")
    public String showRecipeFormForUpdate(@RequestParam("recipeId") int recipeId,
                                          Model theModel){
        Recipe theRecipe = recipeService.findRecipeById(recipeId);
        theModel.addAttribute("recipeModel", theRecipe);
        theModel.addAttribute("buttonText", "Edytuj");

        return "recipe-form";
    }


    @PostMapping("/processRecipeForm")
    public String processRecipeForm(
            @Valid @ModelAttribute ("recipeModel") RecipeModel recipeModel,
            BindingResult theBindingResult){

        if (theBindingResult.hasErrors()){
            return "redirect:recipe-form";
        }

        recipeService.save(recipeModel);

        return "redirect:/";

    }

    @GetMapping("/openRecipe")
    public String openRecipe(
            @RequestParam("recipeId") int recipeId,
            Model theModel){

        Recipe theRecipe = recipeService.findRecipeById(recipeId);
        if(theRecipe == null){
            return "404page";
        }
        theModel.addAttribute("recipe", theRecipe);

        return "recipe";
    }



    @GetMapping("/delete")
    public String deleteRecipe(@RequestParam("recipeId") int theId) {

        // delete the customer
        recipeService.delete(theId);

        return "redirect:";
    }




}
