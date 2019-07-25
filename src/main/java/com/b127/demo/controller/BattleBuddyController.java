package com.b127.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;


import com.b127.demo.entity.BattleBuddy;

import com.b127.demo.service.custom.BattlebuddyService;
import com.b127.demo.service.custom.UserService;

@Controller
public class BattleBuddyController {

	@Autowired
	private UserService userService;

	@Autowired
	private BattlebuddyService battlebuddyService;

	@RequestMapping("/battlebuddy")
	public String buddyHome(Model model) {
		List<BattleBuddy> buddies = battlebuddyService.getAllBattlebuddies();

		model.addAttribute("buddies", buddies);

		return "home-blog";
	}

	@RequestMapping(value = "/add-buddy", method = RequestMethod.POST)
	public String addBuddy(Model model, @ModelAttribute("battleBuddy") BattleBuddy battleBuddy,
			@SessionAttribute("loggedUserId") int userId) {
		battleBuddy.setUser(userService.findById(userId));

		battlebuddyService.insert(battleBuddy);

		List<BattleBuddy> buddies = battlebuddyService.getAllBattlebuddies();
		
	

		model.addAttribute("buddies", buddies);
		model.addAttribute("successMessage", "Register Success");

		return "home-blog";

	}

}
