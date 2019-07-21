package com.b127.demo.service.custom.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.b127.demo.entity.Role;
import com.b127.demo.entity.SecuredUser;
import com.b127.demo.entity.User;
import com.b127.demo.repository.UserRepository;
import com.b127.demo.service.custom.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username+"******loadBYUsername");
		User user = userRepository.findByEmail(username);
		
		if (user==null) {
			System.out.println("Inside null check.....");
			throw new UsernameNotFoundException("Invalid username or password");
			
		}
		
		return new SecuredUser(user);
		
		
	}

	

	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userRepository.findAll().forEach(e -> list.add(e));
		
		return list;
	}

	@Override
	public User findById(int id) {
		User user = userRepository.findById(id).orElse(null);
		return user;
	}

	

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User insert(User user) {
		
		User localUser = userRepository.findById(user.getId()).orElse(null);
		
		if(localUser == null) {
			localUser = new User();
		}
		localUser.setId(user.getId());
		localUser.setEmail(user.getEmail());
		localUser.setName(user.getName());
		localUser.setUsername(user.getUsername());
		localUser.setPassword(passwordEncoder.encode(user.getPassword()));
		localUser.setRoles(Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(localUser);
	}

	@Override
	public User findByEmail(String email) {
		System.out.println("inside find by email....");
		return userRepository.findByEmail(email);
	}



}
