package com.b127.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.b127.demo.entity.Feed;
import com.b127.demo.service.custom.FeedService;
import com.b127.demo.service.custom.UserService;

@Controller
public class FeedController {

	@Autowired
	private FeedService feedService;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/feed")
	public String getFeeds(Model model) {
		List<Feed> feeds = feedService.getAllFeeds();
		model.addAttribute("feeds", feeds);

		return "videos";

	}

	@RequestMapping(value = "/add-feed", method= RequestMethod.POST)
	public String addFeeds(Model model, @ModelAttribute("feed") Feed feed,
			@SessionAttribute("loggedUserId") int userId) {
		feed.setUser(userService.findById(userId));
		
		feedService.insert(feed);
		
		List<Feed> feeds = feedService.getAllFeeds();
		model.addAttribute("feeds", feeds);
		
		return "videos";
	}

}
