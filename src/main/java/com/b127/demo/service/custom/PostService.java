package com.b127.demo.service.custom;

import java.util.List;

import com.b127.demo.entity.Post;


public interface PostService {
	
	List<Post> findAll();

    Post findById(int id);

    void delete(int id);

    Post insert(Post post);
}
