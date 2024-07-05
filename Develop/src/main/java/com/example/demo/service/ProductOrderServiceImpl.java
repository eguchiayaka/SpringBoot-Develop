package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ProductOrder;
import com.example.demo.form.ProductOrderForm;
import com.example.demo.repository.ProductOrderRepository;

@Service
@Transactional
public class ProductOrderServiceImpl implements ProductOrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Override
    public ProductOrder saveProductOrder(ProductOrderForm productOrderForm) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setStore_id(productOrderForm.getStore_id());
        productOrder.setProduct_infos_id(productOrderForm.getProduct_infos_id());
        productOrder.setNumber_order(productOrderForm.getNumber_order());
        productOrder.setTotal_price(productOrderForm.getTotal_price());

        return productOrderRepository.save(productOrder);
    }

    @Override
    public ProductOrder getProductOrderById(Long id) {
        return productOrderRepository.getProductOrderById(id);
    }
}
