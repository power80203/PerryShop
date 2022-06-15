package com.perry.admin.user;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestEncoderPassword {
	
	
	@Test
	public void testEncode() {
		BCryptPasswordEncoder en = new BCryptPasswordEncoder();
		
		String s1 = "power";
		
		String s1_en = en.encode(s1);
		
		System.out.println(s1_en);
		
		
		System.out.println("測試結果  "+en.matches(s1, s1_en));
		
		
		
		
	}

}
