package com.perry.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	
	@GetMapping("")
	public String viewHomePage() {
		// TODO Auto-generated method stub
		
		return "index";

	}

}
