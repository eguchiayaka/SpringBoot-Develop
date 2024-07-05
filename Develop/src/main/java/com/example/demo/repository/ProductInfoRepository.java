package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ProductInfo;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {

	ProductInfo getProductInfoById(Long id);

}
