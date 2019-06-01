package com.pgruszka93.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	// add request mapping for /adminPanel

	@GetMapping("/adminPanel")
	public String showAdminPanel() {
		
		return "admin-panel";
	}
	


}










