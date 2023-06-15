package com.ecommerce.demo.ServiceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.demo.CategoryProductApplication;
import com.ecommerce.demo.Repository.ProductRepository;
import com.ecommerce.demo.Service.ProductService;
import com.ecommerce.demo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{

	private static final Logger logger=LoggerFactory.getLogger(CategoryProductApplication.class);

	@Autowired
	private ProductRepository productRepository;
	
//	@Autowired
//	private final ProductRepository productRepository;
	
////	@Autowired
//    public ProductServiceImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
    //}
	
	@Override
	public Product saveProduct(Product product) {
		logger.info("Product Service Implementation : saveProduct() method");

		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		logger.info("Product Service Implementation : getAllProducts() method");

		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		
		return productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException ("Product not found"));
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
		
	}

}
