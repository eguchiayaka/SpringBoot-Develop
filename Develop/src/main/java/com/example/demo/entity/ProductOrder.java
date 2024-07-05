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
@Table(name = "product_orders")
public class ProductOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "store_id", nullable = false)
	private Long store_id;
	
	@Column(name = "product_infos_id", nullable = false)
	private Long product_infos_id;
	
	@Column(name = "number_order", nullable = false)
	private String number_order;
	
	@Column(name = "total_price", nullable = false)
	private String total_price;
	

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}

