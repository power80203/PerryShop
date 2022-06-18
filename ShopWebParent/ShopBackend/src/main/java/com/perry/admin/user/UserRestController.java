package com.perry.admin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
	
	/*
	 * ajax 會來呼叫這個區域
	 * 
	 */
	
	
	@Autowired
	private UserService urService;
	
	
//	@PostMapping("/users/check_email")
	@RequestMapping(value="/users/check_email", method= {RequestMethod.POST,RequestMethod.GET })
	public String checkUserDuplicated(@Param("eamil") String eamilString) {
		
		System.out.println("check_email");
		
		return urService.isUserUnique(eamilString) ? "ok":"dup";
		
	}
	
	

}
