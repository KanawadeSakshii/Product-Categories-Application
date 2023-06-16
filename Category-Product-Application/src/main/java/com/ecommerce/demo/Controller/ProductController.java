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
import com.ecommerce.demo.Service.ProductService;
import com.ecommerce.demo.entity.Product;


@RestController
@RequestMapping("/api/products")
public class ProductController {
	 
	private static final Logger logger=LoggerFactory.getLogger(CategoryProductApplication.class);

	@Autowired
	private  ProductService productService;

//    @Autowired
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping //http://localhost:8080/api/products?page=2
    public ResponseEntity<List<Product>> getAllProducts( @RequestParam("page") int page) {
    	List<Product> Allproduct= productService.getAllProducts();
    	logger.info("\"Product Rest Controller Implementation : getAllProducts() method\"");
        return ResponseEntity.ok().body(Allproduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
       Product getProduct=  productService.getProductById(id);
   	logger.info("\"Product Rest Controller Implementation : getProductById() method\"");
         return ResponseEntity.ok().body(getProduct);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
         Product cProduct=productService.saveProduct(product);
        	logger.info("\"Product Rest Controller Implementation : createProduct() method\"");
         return ResponseEntity.ok().body(cProduct);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product ) {
    	Product getnewProduct=productService.getProductById(id);
    	getnewProduct.setId(product.getId());
    	getnewProduct.setName(product.getName());
    	getnewProduct.setCategory(product.getCategory());
    	Product Productupdate= productService.saveProduct(getnewProduct);
    	logger.info("\"Product Rest Controller Implementation : updateProduct() method\"");
    	 return ResponseEntity.ok().body(Productupdate);
    }
}
