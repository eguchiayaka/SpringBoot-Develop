	package com.example.demo.service;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SmallCategory;
import com.example.demo.repository.SmallCategoryRepository;

	@Service
	public class SmallCategoryServiceImpl implements SmallCategoryService {

		@Autowired
	    private SmallCategoryRepository smallCategoryRepository;
		
		public List<SmallCategory> findBySubCategoryId(Long sub_category_id) {
	        return smallCategoryRepository.findBySubCategoryId(sub_category_id);
	    }
		public List<SmallCategory> getAllSmallCategories() {
	        return smallCategoryRepository.findAll(); // あるいは適切な方法で全てのカテゴリを取得する
	    }
		   public SmallCategory getSmallCategoryById(Long smallCategoryId) {
		        return smallCategoryRepository.findById(smallCategoryId)
		                                     .orElseThrow(() -> new RuntimeException("SmallCategory not found with id: " + smallCategoryId));
		    }
}
