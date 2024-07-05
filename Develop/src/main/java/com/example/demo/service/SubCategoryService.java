package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.SubCategory;


public interface SubCategoryService {

	 public List<SubCategory> findByCategoryId(Long category_id);
	 List<SubCategory> getAllSubCategories();
}
