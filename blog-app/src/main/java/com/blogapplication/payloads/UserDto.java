package com.blogapplication.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	
	private int id;
	
	@NotEmpty
	@Size(min = 10,message ="UserName should be atleast 10 characters" )
	private String name;
	
	@Email(message="Please give correct email address")
	private String email;
	
	@NotEmpty
	@Size(min = 3,max=10,message = "Password should be atleast min of 3 and max 0f 10 charcters")
	//@pattern used for giving regular expressions useit when required
	private String password;
	
	@NotEmpty
	@Size(min= 5,max=20,message="About should considered min of 5 and max of 20 characters")
	private String about;

}
