package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {

	Product findBySmallCategoryId(Long smallCategoryId);
	List<Product> findByProductsName(String productsName);
	public List<Product> getAllProducts();
	
	Product getProductById(Long id);
}