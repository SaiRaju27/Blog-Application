package com.blogapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.payloads.UserDto;
import com.blogapplication.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//POST create user
	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto ){
		
		UserDto userDto2=this.userService.createUser(userDto);
		return new ResponseEntity<>(userDto2,HttpStatus.CREATED);
		
	}
	
	//GET get all users
	
	//GET get by id
	
	//UPDATE update user
	
	//DELETE delete user
	
	

}
