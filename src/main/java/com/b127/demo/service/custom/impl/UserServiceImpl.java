package com.b127.demo.service.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.demo.entity.User;
import com.b127.demo.repository.UserRepository;
import com.b127.demo.service.custom.UserService;

/**
 * Created by Avalanche Pvt.Ltd. User: Dilshan.Fardil Date: 6/26/2019 Time: 8:25
 * PM}
 */

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public User getById(int id) {
		User user = userRepository.getOne(id);
		return user;
	}

	@Override
	public void update(User user) {
		User userC = userRepository.getOne(user.getUserId());
		userC.setName(user.getName());
		userC.setPassword(user.getPassword());
		userC.setUserName(user.getUserName());
		userRepository.save(userC);
	}

	@Override
	public void delete(int id) {
		User user = userRepository.getOne(id);
		userRepository.delete(user);
	}

	@Override
	public void insert(User user) {
		
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}

	@Override
	public User findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	}

}
