package com.perry.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.perry.common.entity.User;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService ur;
	
	
	@GetMapping("/users")
	public String listAll(Model model) {
		
		List<User> listUsers = ur.listAll();
		model.addAttribute("listUsers",listUsers);
		
		return "users";
	}
	

}
