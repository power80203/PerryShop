package com.perry.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.perry.common.entity.Role;
import com.perry.common.entity.User;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository uRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	public List<User> listAll() {
		
		return (List<User>) uRepository.findAll();
		
	}
	
	public List<Role> listRoles() {
		
		return (List<Role>) roleRepository.findAll();
		
	}

	
	private void encodePassowrd(User u) {
		
		String s_enString  = passwordEncoder.encode(u.getPassword());
		u.setPassword(s_enString);
		
	}
	
	
	
	public void save(User user) {
		// TODO Auto-generated method stub
		//加密密碼
		encodePassowrd(user);
		
		uRepository.save(user);
		
	}
	
	public boolean isUserUnique(String email) {
		
		String userEmaiString  = email;
		
		return uRepository.getUserByEmail(userEmaiString) == null ;
		
		
		
	}
	

}
