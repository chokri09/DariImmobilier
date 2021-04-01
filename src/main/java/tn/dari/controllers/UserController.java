package tn.dari.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.entities.User;
import tn.dari.services.IuserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IuserService userservice;
	
	@GetMapping(value = "/retrieves-all-user")
	@ResponseBody
	public List<User> getUser() {
		List<User> list = userservice.retreiveAllUser();
		return list;
	}
	@PostMapping(value="save-user")
	public User saveUser(@RequestBody User user) {
		userservice.addUser(user);
		return user;
	
	}
	@PutMapping("/update-user/{id}")
  	@ResponseBody
  	public ResponseEntity<String> updateUser(
  		@RequestBody User user,@PathVariable("id")int id) {
		userservice.updateUser(user, id);
  		return new ResponseEntity<String>("User updated successfully",HttpStatus.OK);
  		
  	}
}
