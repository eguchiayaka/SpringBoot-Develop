package com.example.demo.form;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductOrderForm implements Serializable {

	private Long id;

	@NotNull
	private Long store_id;

	@NotNull
	private Long product_infos_id;
	
	@NotBlank
	@Min(value = 0)
	private String number_order;

	@NotBlank
	@Min(value = 0)
	private String total_price;
	
	

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
