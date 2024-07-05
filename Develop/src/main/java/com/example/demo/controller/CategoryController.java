package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Product;
import com.example.demo.entity.SmallCategory;
import com.example.demo.entity.SubCategory;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.service.SmallCategoryService;
import com.example.demo.service.SubCategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SubCategoryService subCategoryService;
	@Autowired
	private SmallCategoryService smallCategoryService;
	@Autowired
	private ProductService productService;
	
	
	
	 @GetMapping("/categories")
	    public String listCategories(Model model) {
	        model.addAttribute("categories",categoryService.findAll());
	        return "categories"; // users.htmlを返す
	    }
	 
	 @GetMapping("/categories/{id}")
	 public String listSubCategories(@PathVariable("id") Long category_id, Model model) {
	     List<SubCategory> subCategories = subCategoryService.findByCategoryId(category_id);   
	     model.addAttribute("sub_categories", subCategories); // 特定のカテゴリーIDに関連する中カテゴリーのみを追加
	     model.addAttribute("categoryId", category_id);
	     return "sub_categories"; // sub_categories.html を返す
	 }

	 @GetMapping("/categories/{categoryId}/{subCategoryId}")
	 public String listSmallCategories(@PathVariable("categoryId") Long categoryId,
	                                   @PathVariable("subCategoryId") Long subCategoryId,
	                                   Model model) {
	     List<SmallCategory> smallCategories = smallCategoryService.findBySubCategoryId(subCategoryId);
	     model.addAttribute("small_categories", smallCategories);
	     model.addAttribute("sub_categoryId", subCategoryId);
	     return "small_categories";
	 }
	 
	 @GetMapping("/categories/{categoryId}/{subCategoryId}/{smallCategoryId}")
	 public String products(@PathVariable("categoryId") Long categoryId,
	                        @PathVariable("subCategoryId") Long subCategoryId,
	                        @PathVariable("smallCategoryId") Long smallCategoryId,
	                        Model model) {
	     Product product = productService.findBySmallCategoryId(smallCategoryId);
	     model.addAttribute("product", product); // "product"を修正
	     return "small_category_details"; 
	 }

	 
	 }
