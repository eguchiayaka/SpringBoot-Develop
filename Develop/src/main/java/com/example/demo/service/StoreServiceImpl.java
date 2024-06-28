package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Store;
import com.example.demo.form.StoreEditForm;
import com.example.demo.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public void updateStore(Long storeId, StoreEditForm storeEditForm) {
        Store store = storeRepository.findById(storeId)
                                     .orElseThrow(() -> new IllegalArgumentException("店舗が見つかりません: " + storeId));

        store.setStore_name(storeEditForm.getStore_name());
        store.setAddress(storeEditForm.getAddress());

        LocalDateTime now = LocalDateTime.now();
        if (store.getCreatedAt() == null) {
            store.setCreatedAt(now);
        }
        store.setUpdatedAt(now);

        storeRepository.save(store);
    }

    public Store getStoreById(Long storeId) {
        return storeRepository.findById(storeId).orElse(null);
    }
}
