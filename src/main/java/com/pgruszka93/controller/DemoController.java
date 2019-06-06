package com.pgruszka93.controller;

import com.pgruszka93.entity.Recipe;
import com.pgruszka93.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class DemoController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String showHome(Model model) {

		Collection<Recipe> recipes = userService.loadNewestRecipes();



		model.addAttribute("recipes", recipes);

		return "home";
	}

	@GetMapping("/loadMoreRecipes")
	public String addMoreRecipes(Model model){
		Collection<Recipe> recipes = userService.loadNewestRecipes();

		model.addAttribute("recipes", recipes);

		return "add-more-recipes";
	}

	@GetMapping("/adminPanel")
	public String showAdminPanel() {
		
		return "admin-panel";
	}

	


}










