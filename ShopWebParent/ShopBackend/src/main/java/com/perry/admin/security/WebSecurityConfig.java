package com.perry.admin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;


/*
 * 成立這個文件的目的是想客製不要每一個頁面都去強制login
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public PasswordEncoder PasswordEncoder() {
		
		return new BCryptPasswordEncoder() ;
	}
	
	@Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                .anyRequest().permitAll()
//                authenticated()把permitAll換這個就會開始執行
            ).csrf().disable()
            .httpBasic(withDefaults());
        return http.build();
    }

	
	
	
	
}
