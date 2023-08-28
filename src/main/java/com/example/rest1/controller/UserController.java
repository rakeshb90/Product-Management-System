package com.example.rest1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest1.entity.User;
import com.example.rest1.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUser();
	}
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	@GetMapping("/users/{name}")
	public User getUserByName(@PathVariable("name")String name)
	{
		return userService.getUserByname(name);
	}
	@PutMapping("/users")
	public User updateUser(@RequestBody User user)
	{
		return userService.updateUser(user);
	}
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable("id")int id)
	{
		userService.deleteUser(id);
		return "Successfullt deleted User of ID: "+id;
	}
}
