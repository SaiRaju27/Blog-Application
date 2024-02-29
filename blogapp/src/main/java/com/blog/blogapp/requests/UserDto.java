package com.blog.blogapp.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
		private int id;
		
		@NotEmpty
		@Size(min = 4 ,message = "Minimum 4 characters needed")
		private String name;
		
		@Email
		@NotEmpty
		private String email;
		
		@NotEmpty
		@Size(min = 8 ,message = "Minimum 8 characters needed")
		private String password;
		
		@NotEmpty
		private String about;

}
