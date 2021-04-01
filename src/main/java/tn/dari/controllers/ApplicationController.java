package tn.dari.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class ApplicationController {
	
	
	@GetMapping("/process")
	public String process (){
		return "************    Hi User !!   ***********    Welcome to Dari.Tn   ************";
	}

}
