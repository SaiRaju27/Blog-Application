package com.blogapplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;

import com.blogapplication.entities.User;
import com.blogapplication.payloads.UserDto;
import com.blogapplication.repositories.UserRepository;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto dto) {
		//here we are accepting userdto object and need to convert to user object to save in database
		User user = this.userDtoToUser(dto);
		User savedUser = this.userRepository.save(user);
	    return this.userToUserdto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto dto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub

	}
	
	
	//to convert userdto to user entity
	public User userDtoToUser(UserDto userDto) {
		
		User user=new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		return user;
		
	}
	
	//to convert user entity to userdto
		public UserDto userToUserdto(User user) {
			
			UserDto userDto=new UserDto();
			userDto.setId(user.getId());
			userDto.setName(user.getName());
			userDto.setEmail(user.getEmail());
			userDto.setPassword(user.getPassword());
			userDto.setAbout(user.getAbout());
			return userDto;
			
		}

}
