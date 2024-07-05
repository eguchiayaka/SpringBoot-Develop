package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "manufacturer_id", nullable = false)
	private Long manufacturerId;

	@Column(name = "small_category_id", nullable = false)
	private Long smallCategoryId;
	
	@Column(name = "products_name", nullable = false)
	private String productsName;
	
	@Column(name = "products_explation", nullable = false)
	private String products_explation;
	

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	
}

