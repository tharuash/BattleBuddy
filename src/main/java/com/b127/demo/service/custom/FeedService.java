package com.b127.demo.service.custom;

import java.util.List;

import com.b127.demo.entity.Feed;

public interface FeedService {
	
	List<Feed> getAllFeeds();
	
	Feed findById(int feedId);
	
	void delete(int feedId);
	
	Feed insert(Feed feed);
	
	List<Feed> findByUserId(int userId);
}
