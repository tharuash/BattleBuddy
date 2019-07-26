package com.b127.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.b127.demo.entity.Forum;
import com.b127.demo.service.custom.ForumService;

@Controller
public class ForumController {
	
	@Autowired
	private ForumService forumService;
	

	
	@RequestMapping(value = "/forum")
	public String forum(Model model) {
		List<Forum> forums = forumService.findAll();
		
		model.addAttribute("forums", forums);
		
		return "forum-topic";
	}
}
