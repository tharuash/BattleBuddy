package com.b127.demo.service.custom.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.demo.entity.Feed;
import com.b127.demo.repository.FeedRepository;
import com.b127.demo.service.custom.FeedService;

@Service
public class FeedServiceImpl implements FeedService {
	
	@Autowired
	FeedRepository feedRepository;
	
	@Override
	public List<Feed> getAllFeeds() {
		List<Feed> list = new ArrayList<>();
		feedRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public Feed findById(int feedId) {
		return feedRepository.findById(feedId).orElse(null);
	}

	@Override
	public void delete(int feedId) {
		feedRepository.deleteById(feedId);
		
	}

	@Override
	public Feed insert(Feed feed) {
		Feed localFeed = feedRepository.findById(feed.getFeedId()).orElse(null);
		
		if(localFeed == null) {
			localFeed = new Feed();
		}
		
		localFeed.setFeedId(feed.getFeedId());
		localFeed.setTitle(feed.getTitle());
		localFeed.setText(feed.getText());
		localFeed.setCreatedTime(feed.getCreatedTime());
		localFeed.setUser(feed.getUser());
		localFeed.setLikes(feed.getLikes());
		localFeed.setVideo(feed.getVideo());
		
		return feedRepository.save(localFeed);
	}

	@Override
	public List<Feed> findByUserId(int userId) {
		List<Feed> list = new ArrayList<>();
		feedRepository.findByUserId(userId).forEach(e -> list.add(e));
		return list;
	}

}
