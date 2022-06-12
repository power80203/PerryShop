package com.perry.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perry.common.entity.Role;
import com.perry.common.entity.User;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository uRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	

	public List<User> listAll() {
		
		return (List<User>) uRepository.findAll();
		
	}
	
	public List<Role> listRoles() {
		
		return (List<Role>) roleRepository.findAll();
		
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		uRepository.save(user);
		
	}
	

}
