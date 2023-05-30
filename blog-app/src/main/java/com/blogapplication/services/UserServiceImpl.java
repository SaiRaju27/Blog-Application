package com.blogapplication.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.stereotype.Service;

import com.blogapplication.entities.User;
import com.blogapplication.exceptions.ResourceNotFoundException;
import com.blogapplication.payloads.UserDto;
import com.blogapplication.repositories.UserRepository;

@Service
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
		User user=this.userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setAbout(dto.getAbout());
		user.setPassword(dto.getPassword());
		
		User updatedUser=this.userRepository.save(user);
		return this.userToUserdto(updatedUser);
	}

	@Override
	public UserDto getUserById(Integer id) {
		// TODO Auto-generated method stub
		User user=this.userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id" ,id));
		
		return this.userToUserdto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users=this.userRepository.findAll();
		
//		List<UserDto> dtos=users.stream().forEach(user->this.userToUserdto(user));
		
		List<UserDto> dtos=users.stream().map(user->this.userToUserdto(user)).collect(Collectors.toList());
		
		return dtos;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
        User user=this.userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id" ,id));
		
		this.userRepository.delete(user);

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
