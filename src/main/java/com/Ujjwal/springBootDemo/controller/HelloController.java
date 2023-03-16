package com.Ujjwal.springBootDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Component
//@Controller
@RestController
public class HelloController {
	
	//@RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
	@GetMapping(value = "/helloWorld")
	public String helloWorld() {
		return "Welcome to Ujjwal's demo change again and again";
		
	}

}
