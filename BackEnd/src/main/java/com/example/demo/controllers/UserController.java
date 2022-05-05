package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {

		return userService.updateUser(user);
	}
	
	@GetMapping("/all")
	public List<User> getAllUsers(){
		return userService.getAll();
	}

	@DeleteMapping("/delete/{id}")

	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	@GetMapping("/get/{id}")
	public User findById(@PathVariable Long id) {
		return userService.findById(id);
	}

}
