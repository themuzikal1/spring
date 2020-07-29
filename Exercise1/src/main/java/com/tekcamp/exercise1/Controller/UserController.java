package com.tekcamp.exercise1.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.tekcamp.exercise1.Model.User;
import com.tekcamp.exercise1.Services.UserService;


@RestController
@RequestMapping("users")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
		
	}
	
	
	@GetMapping
	public List<User> getUsers() {
		List<User> returnValue = userService.getUsers();
		return returnValue;
		
	}
	
	@GetMapping(path ="/{firstName}")
	public User getUser(@PathVariable String firstName) {
		User returnValue = userService.getUser(firstName);
		return returnValue;
		
	}
	
	@PostMapping
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
		
		
	}
	
	@PutMapping
	public void updateUser() {
	
		
	}
	
	@DeleteMapping
	public void deleteUser() {
		
		
	}
	

}
