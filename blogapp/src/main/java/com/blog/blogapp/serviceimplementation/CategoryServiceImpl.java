package com.blog.blogapp.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import com.blog.blogapp.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.blogapp.entity.Category;
import com.blog.blogapp.repository.CategoryRepo;
import com.blog.blogapp.requests.CategoryDto;
import com.blog.blogapp.service.CategoryService;

@Service
@Slf4j
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
		Category category = this.categoryRepo.findById(categoryId).
				orElseThrow(() -> new ResourceNotFoundException("Catrgory","Id",categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCategory = this.categoryRepo.save(category);
		return mapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) throws ResourceNotFoundException {

		Category category = this.categoryRepo.findById(categoryId).
				orElseThrow(() -> {
					log.error("Category Not found in DB - {}", CategoryServiceImpl.class);
					return new ResourceNotFoundException("Category", "ID", categoryId);
				});
		this.categoryRepo.deleteById(category.getCategoryId());
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).
				orElseThrow(() -> {
					log.error("Category Not found in DB - {}", CategoryServiceImpl.class);
					return new ResourceNotFoundException("Category", "ID", categoryId);
				});
		return this.mapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = null;
		categories = this.categoryRepo.findAll();
		List<CategoryDto>  catDto = null;
        catDto = categories.stream().map(category -> this.mapper.map(category, CategoryDto.class)).collect(Collectors.toList());
        return catDto;
	}

}
