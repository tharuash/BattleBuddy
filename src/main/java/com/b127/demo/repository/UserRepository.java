package com.b127.demo.repository;



import org.springframework.data.repository.CrudRepository;


import com.b127.demo.entity.User;




public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByEmail(String email);

}
