package com.perry.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.perry.common.entity.Role;
import com.perry.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository ur;

	//空run就會去調用相關的table
	@Test
	void testCreateUser() {
	}
	
	
	@Test
	void testCreateUsers() {
		User mm = new User("abc@java.net", "123456", "A", "B");
		mm.addRole(null);
		//User userSave = ur.save(mm);
		//assertThat(userSave.getId()).isGreaterThan(0);
	}
	
	@Test
	void testCreateUserWithMultiRoles() {
		
		User perrUser = new User("pp@foxconn.com", "a123456","Wu","Perry");
		
		Role roleEditor = new Role(3);
		Role roleassitRole  = new Role(5);
		perrUser.addRole(roleassitRole);
		perrUser.addRole(roleEditor);

		
		ur.save(perrUser);
		
		
	}
	
	@Test
	void testListAllUsers() {
		Iterable<User> useIterable = ur.findAll();		
		useIterable.forEach(t -> System.out.println(t));
		
	}
	
	
	@Test
	void testGetUserByEmail() {
		String emailString = "abc@java.net";
		User u = ur.getUserByEmail(emailString);
		
		assertThat(u).isNotNull();
		
		
	}
}


