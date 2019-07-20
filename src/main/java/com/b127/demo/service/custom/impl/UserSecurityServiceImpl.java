package com.b127.demo.service.custom.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.b127.demo.entity.User;
import com.b127.demo.repository.UserRepository;

@Service
public class UserSecurityServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		if(null==user) {
			throw new UsernameNotFoundException("Username not found");
		}
		
		return user;
	}

}
