package com.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.service.PersonService;

@Controller
public class HomeController {
	
	@Autowired
	PersonService personService;

	@RequestMapping(path = { "/", "/home" }
	   , method = { RequestMethod.GET, RequestMethod.POST })
	public String home() {
		return "home";
	}
	
	@GetMapping("/test")
	public String test() {
		personService.getAllPerson();
		
		return "test";
	}
}
