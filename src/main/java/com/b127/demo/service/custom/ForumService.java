package com.b127.demo.service.custom;

import java.util.List;

import com.b127.demo.entity.Forum;


public interface ForumService {
	
	List<Forum> findAll();

    Forum findById(int id);

    void delete(int id);

    Forum insert(Forum forum);
}
