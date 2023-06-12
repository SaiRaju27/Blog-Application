package com.blogapplication.services;

import java.util.List;

import com.blogapplication.payloads.CategoryDto;

public interface CategoryService {
	
	//create a category
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update a category
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	//delete a category
	public void deleteCategory(Integer categoryId);
	
	//get a category
	public CategoryDto getCategoryById(Integer categoryId);
	
	//getAll categories
	public List<CategoryDto> getAllCategories();

}
