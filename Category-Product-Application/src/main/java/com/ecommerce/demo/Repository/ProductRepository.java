package com.ecommerce.demo.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Serializable> {

}
