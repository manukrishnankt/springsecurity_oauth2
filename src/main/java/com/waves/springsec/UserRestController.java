package com.waves.springsec;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@GetMapping
	public String getResponse() {
		return "Welcome User !!!";
	}
	
	@GetMapping("/nested")
	public String getNestedResponse() {
		return "User, Nested Is Working !!!";
	}

}
