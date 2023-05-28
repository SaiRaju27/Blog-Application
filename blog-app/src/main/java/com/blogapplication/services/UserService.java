package com.blogapplication.services;

import java.util.List;

import com.blogapplication.payloads.UserDto;

public interface UserService {
	
	public UserDto createUser(UserDto dto);
	public UserDto updateUser(UserDto dto,Integer id);
	public UserDto getUserById(Integer id);
	public List<UserDto> getAllUsers();
	public void deleteUser(Integer id);
	

}
