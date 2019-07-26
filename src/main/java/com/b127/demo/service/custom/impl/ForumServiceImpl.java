package com.b127.demo.service.custom.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.demo.entity.Forum;
import com.b127.demo.repository.ForumRepository;
import com.b127.demo.service.custom.ForumService;

@Service
public class ForumServiceImpl implements ForumService {
	
	@Autowired
	private ForumRepository forumRepository;

	
	@Override
	public List<Forum> findAll() {
		List<Forum> list = new ArrayList<>();
		forumRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public Forum findById(int forumId) {
		return forumRepository.findById(forumId).orElse(null);
	}

	@Override
	public void delete(int forumId) {
		forumRepository.deleteById(forumId);
		
	}

	@Override
	public Forum insert(Forum forum) {
		Forum localForum = forumRepository.findById(forum.getId()).orElse(null);
		
		if(localForum == null) {
			localForum = new Forum();
		}
		
		localForum.setId(forum.getId());
		localForum.setTitle(forum.getTitle());
		localForum.setViews(forum.getViews());
		
		return forumRepository.save(localForum);
	}
}
