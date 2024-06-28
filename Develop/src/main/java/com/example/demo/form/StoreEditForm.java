package com.example.demo.form;

	import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

	@Data
	public class StoreEditForm implements Serializable {

		private Long id;

		@NotBlank
		private String store_name;

		@NotBlank
		private String address;

		private LocalDateTime createdAt;
		private LocalDateTime updatedAt;

	}