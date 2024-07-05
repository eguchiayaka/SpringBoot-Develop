package com.example.demo.service;

import com.example.demo.form.StoreEditForm;

public interface StoreService {
	void updateStore(Long userId, StoreEditForm storeEditForm);
	
}
