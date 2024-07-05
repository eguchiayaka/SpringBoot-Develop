package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductInfo;
import com.example.demo.repository.ProductInfoRepository;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo getProductInfoById(Long id) {
        return productInfoRepository.getProductInfoById(id);
    }
}
