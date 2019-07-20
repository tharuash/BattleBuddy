package com.b127.demo.service.custom;


import java.util.List;

import org.springframework.stereotype.Service;

import com.b127.demo.entity.User;



/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 6/26/2019
 * Time: 8:24 PM}
 */

@Service
public interface UserService{
	List<User> findAll();

    User getById(int id);

    void update(User user);

    void delete(int id);

    void insert(User user);
    
	User findByUsername(String username);
	
	User findByEmail (String email);
	
	
}
