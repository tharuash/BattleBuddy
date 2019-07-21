package com.b127.demo.controller;



import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.b127.demo.entity.SecuredUser;
import com.b127.demo.entity.User;

import com.b127.demo.service.custom.UserService;



@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@RequestMapping("/access-denied")
	public String accessDenied() {
		return "games";
	}

	@RequestMapping("/")
	public String home() {
		return "games";
	}

	@RequestMapping("/toLogin")
	public String toLogin() {
		return "index";
	}

	@RequestMapping("/toRegister")
	public String toRegistration() {
		return "register";
	}
	
	@ModelAttribute("user")
	public User user() {
		return new User();
	}

	@RequestMapping("/login")
	public String login(Model model) {
		System.out.println("inside /login");
		return "profile";
	}
	
	@RequestMapping("profile")
	public String profile(Model model) {
		return "profile";
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String registerNewUser(@ModelAttribute("user") User user, BindingResult result ,Model model) {
		
		User existing = userService.findByEmail(user.getEmail());
		
		if(existing != null) {
			result.rejectValue("email", null, "Email already registered");
		}
		
		if(result.hasErrors()) {
			return "register";
		}
		
		userService.insert(user);

		return "profile";

	}
	
	@RequestMapping(value="/loginPost", method = RequestMethod.POST)
	public String loginPost(Model model, HttpSession httpSession) {
		
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		User loggedUser = ((SecuredUser) authentication.getPrincipal()).getUserDetails();
		
		model.addAttribute("loggedUserId", loggedUser.getId());
		model.addAttribute("loggedUsername", loggedUser.getUsername());
		httpSession.setAttribute("userId", loggedUser.getId());
		
		return "profile";
	}

}
