package com.waves.springsec;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminRestController {
	
	@GetMapping
	public String getResponse() {
		return "Welcome Admin User !!!";
	}
	
	@GetMapping("/nested")
	public String getNestedResponse() {
		return "Admin User, Nested Is Working !!!";
	}

}
