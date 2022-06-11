package com.perry.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.perry.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RoleRepositoryTests {
	
	
	@Autowired
	private RoleRepository repo;
	
	
	@Test
	public void testCreationFirstRole() {
		
		Role adminRole = new Role(); 
		adminRole.setName("ava");
		adminRole.setDescription("123123123");
		Role r =  repo.save(adminRole);
		
		
		System.out.println(r.getId());
		
		assertThat(r.getId()).isGreaterThan(0);
		
	}

}
