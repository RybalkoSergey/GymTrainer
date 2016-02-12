package com.sergeyry.gymtrainer.service.user;

import com.sergeyry.gymtrainer.model.user.Role;
import com.sergeyry.gymtrainer.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String login)	throws UsernameNotFoundException {

		User user = userService.findUserByLogin(login);

		System.out.println("User : "+user);
		if(user==null){
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
	}

	
	private List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Role role : user.getRoles()){
			System.out.println("UserProfile : "+role);
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getType()));
		}
		System.out.print("authorities :"+authorities);
		return authorities;
	}
	
}
