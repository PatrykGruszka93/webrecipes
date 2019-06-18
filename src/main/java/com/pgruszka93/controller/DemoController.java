package com.pgruszka93.controller;

import com.pgruszka93.entity.Recipe;
import com.pgruszka93.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class DemoController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String showHome(Model model, HttpServletRequest request) {


        request.getSession().setAttribute("pageNumber",1);

        int pageNumber = (Integer)request.getSession().getAttribute("pageNumber");
        Collection<Recipe> recipes = userService.loadNewestRecipes(pageNumber);


		model.addAttribute("recipes", recipes);

		return "home";
	}

	@GetMapping("/loadMoreRecipes")
	public String addMoreRecipes(Model model, HttpServletRequest request){

        int pageNumber = (Integer)request.getSession().getAttribute("pageNumber");
        int currentPageNumber = pageNumber +1;
        request.getSession().setAttribute("pageNumber", currentPageNumber);
	    Collection<Recipe> recipes = userService.loadNewestRecipes(currentPageNumber);

		model.addAttribute("recipes", recipes);

		return "add-more-recipes";
	}



}










