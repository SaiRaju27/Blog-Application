package com.blog.blogapp.serviceimplementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blogapp.entity.Category;
import com.blog.blogapp.repository.CategoryRepo;
import com.blog.blogapp.requests.CategoryDto;
import com.blog.blogapp.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

		Category category = this.mapper.map(categoryDto, Category.class);
		Category addedCategory = categoryRepo.save(category);
		return this.mapper.map(addedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub

	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
