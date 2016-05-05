package com.springHibernate.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springHibernate.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {
    
	@Autowired
	protected UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
    public boolean login(@RequestBody Map<String, String> loginMap) {
    	String userName = loginMap.get("userName");
    	String email = loginMap.get("email");
    	if (userName == null || email == null) {
    		return false;
    	}
        return userService.getUser(email,userName) != null;
    }
}