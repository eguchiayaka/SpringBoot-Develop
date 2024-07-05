package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "product_categories")
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "category_id", nullable = false)
	private Long category_id;
	
	@Column(name = "sub_category_id", nullable = false)
	private Long sub_category_id;

	@Column(name = "small_category_id", nullable = false)
	private Long small_category_id;
	
	
}

