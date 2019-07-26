package com.b127.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.b127.demo.entity.Forum;

public interface ForumRepository extends CrudRepository<Forum, Integer> {
	
}
