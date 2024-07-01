package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Store;
import com.example.demo.form.StoreEditForm;
import com.example.demo.service.AdminServiceImpl;
import com.example.demo.service.StoreServiceImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class StoreController {
    @Autowired
    private StoreServiceImpl storeServiceImpl;
    @Autowired
    private AdminServiceImpl adminServiceImpl;
    
	@GetMapping("/stores")
    public String showStoreInfo(Model model) {
        // ログインユーザの店舗情報を取得
        Admin loggedInUser = adminServiceImpl.getLoggedInUser();
        Long storeId = loggedInUser.getStore_id();
        Store store = storeServiceImpl.getStoreById(storeId);
        
        // モデルに店舗情報を追加
        model.addAttribute("store", store);
        return "store_detail"; // store_detail.html テンプレートを返す
    }
    
    @PostMapping("/stores")
    public String loginEdit( Model model) {
    	 // ログインユーザの店舗情報を取得
        Admin loggedInUser = adminServiceImpl.getLoggedInUser();
        Long storeId = loggedInUser.getStore_id();
        Store store = storeServiceImpl.getStoreById(storeId);
        return "redirect:/admin/stores/edit"; // 編集が完了したら編集ページにリダイレクト
    }

    
    @GetMapping("/stores/edit")
    public String showStoreEditForm(Model model) {
        // ログインユーザの店舗情報を取得
        Admin loggedInUser = adminServiceImpl.getLoggedInUser();
        Long storeId = loggedInUser.getStore_id();
        Store store = storeServiceImpl.getStoreById(storeId);

        // 編集フォーム用のオブジェクトを作成して設定
        StoreEditForm storeEditForm = new StoreEditForm();
        storeEditForm.setId(store.getId());
        storeEditForm.setStore_name(store.getStore_name());
        storeEditForm.setAddress(store.getAddress());

        // モデルに店舗情報と編集フォームを追加
        model.addAttribute("store", store);
        model.addAttribute("storeEditForm", storeEditForm);

        return "store_edit"; // store_edit.html テンプレートを返す
    }
    
    @PostMapping("/stores/edit")
    public String processStoreEdit(@ModelAttribute("storeEditForm") @Valid StoreEditForm storeEditForm,
    		BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "store_edit"; // エラーがある場合は編集フォームを再表示
        }
        // 更新処理（例：サービスを呼び出してDBに保存など）
        
        storeServiceImpl.updateStore(storeEditForm.getId(), storeEditForm);

        return "redirect:/admin/stores"; // 編集後に店舗一覧にリダイレクト
    }

}
