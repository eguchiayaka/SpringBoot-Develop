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
@Table(name = "product_infos")
public class ProductInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "product_id", nullable = false)
	private Long product_id;
	
	@Column(name = "manufacturer_id", nullable = false)
	private Long manufacturer_id;
	
	@Column(name = "category_id", nullable = false)
	private Long category_id;
	
	@Column(name = "sub_category_id", nullable = false)
	private Long sub_category_id;

	@Column(name = "small_category_id", nullable = false)
	private Long small_category_id;
	
	@Column(name = "products_name", nullable = false)
	private String productsName;
	
	@Column(name = "products_explation", nullable = false)
	private String products_explation;;
	
	@Column(name = "products_image", nullable = false)
	private String products_image;
	
	@Column(name = "cost_price", nullable = false)
	private String cost_price;
	
	@Column(name = "manufacturer_price", nullable = false)
	private String manufacturer_price;
	
	@Column(name = "sales_price", nullable = false)
	private String sales_price;
	
	@Column(name = "stock", nullable = false)
	private String stock;
	

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}

