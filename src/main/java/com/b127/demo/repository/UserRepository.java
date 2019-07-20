package com.b127.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.b127.demo.entity.User;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 6/23/2019
 * Time: 11:00 PM}
 */


public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
	
	User findByEmail(String email);

}
