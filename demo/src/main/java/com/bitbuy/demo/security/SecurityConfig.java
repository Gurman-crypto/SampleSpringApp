package com.bitbuy.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true )
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	public Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("Using custom configure(HttpSecurity).");
		
		http.authorizeRequests()
		.antMatchers("/api/register").permitAll() //anyone can access 
		.antMatchers("/api/*").authenticated() // only authenticated users can access
		.and()
		.httpBasic();
	} 
	
	//to configure users in spring security : used in memory based authentication to allow using 2 users 
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * auth.inMemoryAuthentication() 
	 * .withUser("admin1") 
	 * .password("admin1")
	 * .roles("USER") 
	 * .and() 
	 * .withUser("admin2")
	 *  .password("admin2") 
	 *  .roles("ADMIN")
	 * .and()
	 *  .passwordEncoder(null);
	 * 
	 * }
	 */
	
	@Bean
	public PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
