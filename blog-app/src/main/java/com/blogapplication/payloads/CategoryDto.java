package com.blogapplication.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
	
	private int categoryId;
	
	@NotEmpty
	@Size(min = 4,message="Please input min of 4 charcters")
	private String categoryTitle;
	@NotEmpty
	@Size(min =10, message="Please give min of 10 characters description")
	private String categoryDescription;

}
