package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;


	 @Service
	 public class ProductServiceImpl implements ProductService {

	     @Autowired
	     private ProductRepository productRepository;

	     public Product findBySmallCategoryId(Long smallCategoryId) {
	    	// smallCategoryIdに対応する単一の製品を検索
	         return productRepository.findBySmallCategoryId(smallCategoryId);
	     }
	     public List<Product> findByProductsName(String productsName) {
	         return productRepository.findByProductsName(productsName);
	     }
	     public List<Product> getAllProducts() {
	         return productRepository.findAll();
	     }
	     public Product getProductById(Long id) {
		    	// smallCategoryIdに対応する単一の製品を検索
		         return productRepository.getProductById(id);
		     }
	 }
