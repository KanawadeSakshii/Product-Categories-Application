package com.ecommerce.demo.ServiceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.demo.CategoryProductApplication;
import com.ecommerce.demo.Repository.CategoryRepository;
import com.ecommerce.demo.Service.CategoryService;
import com.ecommerce.demo.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService{

	private static final Logger logger=LoggerFactory.getLogger(CategoryProductApplication.class);

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category saveCategory(Category category) {
		logger.info("Category Service Implementation : saveCategory() method");
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		logger.info("Category Service Implementation : getAllCategories() method");

		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Invalid Category Id"));
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		
	}

}
