package com.rt.ecps.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.ecps.model.User;
import com.rt.ecps.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	
	@Autowired
	private UserService userService;
	


	@RequestMapping("/toIndex.login")
	public String toIndex(String username,String password,HttpSession session) {
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("username", username);
		map.put("password", password);
		
		User user = userService.getUserByLogin(map);
		
		if(user!=null){
			session.setAttribute("user", user);
			return  "user/index";
		}else{
			return  "redirect:/ecps/console/login.jsp";
		}
		
		
	}
}
