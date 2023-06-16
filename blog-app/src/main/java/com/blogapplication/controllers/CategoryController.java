package com.blogapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.entities.Category;
import com.blogapplication.payloads.ApiResponse;
import com.blogapplication.payloads.CategoryDto;
import com.blogapplication.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/getCategory/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId){
		return new ResponseEntity<CategoryDto>(this.categoryService.getCategoryById(categoryId),HttpStatus.OK);
	}
	
	@GetMapping("/getAllCategories")
	public ResponseEntity<List<CategoryDto>> getAllCategories(){
		return new ResponseEntity<List<CategoryDto>>(this.categoryService.getAllCategories(),HttpStatus.OK);
	}
	
	@PostMapping("/createCategory")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
	
		return new ResponseEntity<CategoryDto>(this.categoryService.createCategory(categoryDto),HttpStatus.CREATED);
	}
	
	@PostMapping("/updateCategory/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @PathVariable Integer categoryId,@RequestBody CategoryDto categoryDto){
	
		return new ResponseEntity<CategoryDto>(this.categoryService.updateCategory(categoryDto,categoryId),HttpStatus.OK);
	}

	@DeleteMapping("/deleteCategory/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
		this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity(new ApiResponse("Category deleted successfully",true),HttpStatus.OK);
	}
}
