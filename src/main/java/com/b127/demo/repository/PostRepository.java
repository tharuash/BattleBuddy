package com.b127.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.b127.demo.entity.Post;

public interface PostRepository extends CrudRepository<Post, Integer>{
	
}
