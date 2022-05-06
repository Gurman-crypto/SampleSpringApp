package com.bitbuy.demo.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bitbuy.demo.entity.User;
import com.bitbuy.demo.repository.UserRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		/*
		 * 1.get UserName and password from Security Authentication Manager
		 *  2.use Spring PasswordEncoder to manipulate and encode password.
		 *  3. use SimpleGrantedAuthority to provide roles
		 *  4.use UsernamePasswordAuthenticationToken to provide username and password authentication only.
		 *  The @PreAuthorize can check for authorization before entering into method.
		 *	and authorizes on the basis of role or the argument which is passed to the method.
		 */
		String email = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		 List<User> user= userRepository.findByEmail(email);
		
			if (user.size() > 0) {
				
				if (passwordEncoder.matches(password, user.get(0).getPassword())) {
					
					/*
					 * List<GrantedAuthority> authorities = new ArrayList<>();
					 * 
					 * authorities.add(new SimpleGrantedAuthority(user.get(0).getRole()));
					 */
					return new UsernamePasswordAuthenticationToken(email, password, null);
				}else  {
					throw new BadCredentialsException("Invalid password");
				}
			} else {
				throw new BadCredentialsException("No user registered with these details");
			}
			
	}

	@Override
	public boolean supports(Class<?> authentication) {
	     return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
