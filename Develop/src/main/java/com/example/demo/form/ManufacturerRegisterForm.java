package com.example.demo.form;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ManufacturerRegisterForm implements Serializable {

	private Long id;

	@NotBlank
	private String manufacturer_name;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
