package com.ecommerce.demo.Service;

import java.util.List;

import com.ecommerce.demo.entity.Category;

public interface CategoryService {

	public Category saveCategory(Category category);
	public List<Category> getAllCategories();
	public Category getCategoryById(Long id);
	public void deleteCategory (Long id);
	
}
