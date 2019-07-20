package com.b127.demo.controller;


import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.b127.demo.entity.User;
import com.b127.demo.service.custom.UserService;
import com.b127.demo.utils.SecurityUtil;




@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String home() {
		return "games";
	}
	
	@RequestMapping("/index")
	public String index() {
		System.out.println("Inside index get");
		return "index";
	}

	@RequestMapping("/register")
	public String goToReg() {
		return "register";
	}

	@RequestMapping("/login")
	public String login() {
		System.out.println("Inside login");
		//model.addAttribute("classActiveLogin", true);
		return "index";
	}
	
	@RequestMapping("/profile")
	public String profile(Model model, Principal principal) {
		System.out.println("Inside profile");
		User user = userService.findByUsername(principal.getName());
		System.out.println(user.getName());
		model.addAttribute("user", user);
		
		return "profile";
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String registerNewUser(@ModelAttribute("email") String userEmail,
			@ModelAttribute("username") String username, Model model) {

		model.addAttribute("classActiveNewAccount", true);
		model.addAttribute("email", userEmail);
		model.addAttribute("username", username);
		
		//System.out.print(userEmail+" "+username);

		if (userService.findByUsername(username) != null) {
			model.addAttribute("usernameExists", true);

			return "index";
		}

		if (userService.findByEmail(userEmail) != null) {
			model.addAttribute("emailExists", true);

			return "index";
		}

		User user = new User();
		user.setUserName(username);
		user.setEmail(userEmail);

		String password = SecurityUtil.randomPassword();
		
		String encryptedPassword = SecurityUtil.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);
		userService.insert(user);

		return "profile";

		

	}

}
