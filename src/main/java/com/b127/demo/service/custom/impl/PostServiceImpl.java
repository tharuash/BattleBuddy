package com.b127.demo.service.custom.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.b127.demo.entity.Post;
import com.b127.demo.repository.PostRepository;
import com.b127.demo.service.custom.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
		
	@Override
	public List<Post> findAll() {
		List<Post> list = new ArrayList<>();
		postRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public Post findById(int postId) {
		return postRepository.findById(postId).orElse(null);
	}

	@Override
	public void delete(int postId) {
		postRepository.deleteById(postId);
		
	}

	@Override
	public Post insert(Post post) {
		Post localPost = postRepository.findById(post.getId()).orElse(null);
		
		if(localPost == null) {
			localPost = new Post();
		}
		
		localPost.setId(post.getId());
		localPost.setTitle(post.getTitle());
		localPost.setText(post.getText());
		localPost.setForum(post.getForum());
		localPost.setUser(post.getUser());
		localPost.setLikes(post.getLikes());
		
		
		return postRepository.save(localPost);
	}

}
