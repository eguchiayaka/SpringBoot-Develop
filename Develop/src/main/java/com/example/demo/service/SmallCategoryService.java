package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.SmallCategory;

public interface SmallCategoryService {

	List<SmallCategory> findBySubCategoryId(Long sub_category_id) ;
	List<SmallCategory> getAllSmallCategories();
	SmallCategory getSmallCategoryById(Long smallCategoryId);
}
