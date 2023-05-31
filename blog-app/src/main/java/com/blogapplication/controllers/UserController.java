package com.blogapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.entities.User;
import com.blogapplication.payloads.ApiResponse;
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
	
	@GetMapping("/getAllusers")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> userDtos =this.userService.getAllUsers();
		return new ResponseEntity<List<UserDto>>(userDtos,HttpStatus.OK);
		
	}
	
	
	//GET get by id
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
		UserDto userDto=this.userService.getUserById(userId);
		return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
		
	}
	
	//UPDATE update user
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<UserDto> getUserById(@RequestBody UserDto userDto, @PathVariable Integer userId){
		
		UserDto userDto2= this.userService.updateUser(userDto, userId);
//		return new ResponseEntity<UserDto>(userDto2,HttpStatus.OK);
		return ResponseEntity.ok(userDto2);
	}
	
	
	//DELETE delete user
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
		this.userService.deleteUser(userId);
		return new ResponseEntity(new ApiResponse("User deleted successfully",true),HttpStatus.OK);
		
	}
	
	
	

}
