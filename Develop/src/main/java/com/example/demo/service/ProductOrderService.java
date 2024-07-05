package com.example.demo.service;

import com.example.demo.entity.ProductOrder;
import com.example.demo.form.ProductOrderForm;

public interface ProductOrderService {
	ProductOrder saveProductOrder(ProductOrderForm productOrderForm) ;
	ProductOrder getProductOrderById(Long id);


}
