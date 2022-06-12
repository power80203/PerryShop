package com.perry.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.perry.common.entity.Role;
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
	
	
	@GetMapping("/users/new")
	public String newUser(Model model) {
		
		List<Role> listRoles =ur.listRoles();
		
		
		
		User user =  new User();
		user.setEnabled(true);
		model.addAttribute("user",user);
		model.addAttribute("listRoles",listRoles);
		
		return "user_form";
		
	}
	
	
	@PostMapping("/users/save")
	public String saveUser(User user) {
		
		
		System.out.println("##############");
		System.out.println(user.getEmail());
		ur.save(user);
		
		
		return "redirect:/users";
		
	}
	

}
