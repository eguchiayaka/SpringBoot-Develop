package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SubCategory;
import com.example.demo.repository.SubCategoryRepository;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
    private SubCategoryRepository subCategoryRepository;
	
	public List<SubCategory> findByCategoryId(Long category_id) {
        return subCategoryRepository.findByCategoryId(category_id);
    }

	 public List<SubCategory> getAllSubCategories() {
	        return subCategoryRepository.findAll(); // あるいは適切な方法で全てのカテゴリを取得する
	    }
}
