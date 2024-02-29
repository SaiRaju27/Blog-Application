package com.blog.blogapp.controllers;

import com.blog.blogapp.entity.Category;
import com.blog.blogapp.requests.CategoryDto;
import com.blog.blogapp.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto) {
        log.info("save controller initiated - {}", CategoryController.class);
        CategoryDto createdCategoryDto = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createdCategoryDto, HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId) {
        log.info("Modify controller initiated - {}", CategoryController.class);
        CategoryDto updatedCategory = categoryService.updateCategory(categoryDto, categoryId);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{categoryId}")
    public  String deleteCategory(@PathVariable Integer categoryId){
        log.info("Delete Controller initiated - {}",CategoryController.class);
        categoryService.deleteCategory(categoryId);
        return "category is deleted Successfully";
    }

    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
        log.info("Get category controller initated - {}",CategoryController.class);
        CategoryDto categoryDto = categoryService.getCategory(catId);
        return ResponseEntity.ok(categoryDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        log.info("Get all controller initated - {}",CategoryController.class);
        List<CategoryDto> categoryDtos = categoryService.getAllCategory();
        return ResponseEntity.ok(categoryDtos);

    }
}
