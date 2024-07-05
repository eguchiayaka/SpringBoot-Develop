package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findBySmallCategoryId(Long smallCategoryId);
	List<Product> findByProductsName(String productsName);
	Product getProductById(Long id);
}
