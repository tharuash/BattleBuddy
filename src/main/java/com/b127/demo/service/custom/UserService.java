package com.b127.demo.service.custom;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;


import com.b127.demo.entity.User;



public interface UserService extends UserDetailsService{
	List<User> findAll();

    User findById(int id);

    void delete(int id);

    User insert(User user);
   
    User findByEmail (String email);
	
	
}
