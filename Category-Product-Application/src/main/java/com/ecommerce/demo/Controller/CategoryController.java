package com.ecommerce.demo.Controller;
/**
 * 
 * 
  @author: Kanawade Sakshii 
 * 
 * 
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.demo.CategoryProductApplication;
import com.ecommerce.demo.Service.CategoryService;
import com.ecommerce.demo.entity.Category;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	private static final Logger logger=LoggerFactory.getLogger(CategoryProductApplication.class);

	@Autowired
	private CategoryService categoryService;

//    @Autowired
//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
    
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category ) {
    	logger.info("Category Rest Controller Implementation: createCategory() method");
    	Category categories= categoryService.saveCategory(category);
    	 return ResponseEntity.ok().body(categories);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
    	logger.info("Category Rest Controller Implementation: getCategoryById() method");
    	Category categoryid=categoryService.getCategoryById(id);
    	 return ResponseEntity.ok().body(categoryid);
    }
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(@RequestParam("page") int page){
    	logger.info("Category Rest Controller Implementation: getAllCategories() method");

    	List<Category> AllCategory = categoryService.getAllCategories();
    	 return ResponseEntity.ok().body(AllCategory);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
    	logger.info("Category Rest Controller Implementation: deleteCategory() method");
        categoryService.deleteCategory(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category ) {
    	logger.info("Category Rest Controller Implementation: updateCategory() method");
    	Category categoryupdate= categoryService.saveCategory(category);
    	 return ResponseEntity.ok().body(categoryupdate);
    }
}
