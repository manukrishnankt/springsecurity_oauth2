package com.waves.springsec;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class GuestController {
	@GetMapping
	public String getResponse() {
		return "Welcome Guest User !!!";
	}
	
	@GetMapping("/nested")
	public String getNestedResponse() {
		return "Guest User, Nested Is Working !!!";
	}
}
