package com.b127.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.b127.demo.entity.Feed;

public interface FeedRepository extends CrudRepository<Feed, Integer>{
	
	List<Feed> findByUserId(int userId);

}
