package com.Ujjwal.springBootDemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Component
//@Controller
@RestController
public class HelloController {

	@Value("${welcome.message}")
	private String welcomeMessage;
	
	//@RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
	@GetMapping(value = "/helloWorld")
	public String helloWorld() {
		return welcomeMessage;
		
	}

}
