package com.perry.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perry.common.entity.User;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository uRepository;
	
	public List<User> listAll() {
		
		return (List<User>) uRepository.findAll();
		
	}

}
