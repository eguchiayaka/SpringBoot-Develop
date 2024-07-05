package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductInfo;
import com.example.demo.entity.SmallCategory;
import com.example.demo.entity.SubCategory;
import com.example.demo.form.ProductOrderForm;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductInfoService;
import com.example.demo.service.ProductService;
import com.example.demo.service.SmallCategoryService;
import com.example.demo.service.SubCategoryService;

@Controller
@RequestMapping("/admin")
public class ProductController {
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private SubCategoryService subCategoryService;
    
    @Autowired
    private SmallCategoryService smallCategoryService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private ProductInfoService productInfoService;
    

    
    @GetMapping("/products")
    public String showProductForm(Model model, String keyword) {
        List<Product> products = productService.getAllProducts();
        List<Product> product = productService.findByProductsName(keyword);
        List<Category> categories = categoryService.getAllCategories();
        List<SubCategory> sub_categories = subCategoryService.getAllSubCategories();
        List<SmallCategory> small_categories = smallCategoryService.getAllSmallCategories();
        model.addAttribute("products", products);
        model.addAttribute("product", product);
        model.addAttribute("keyword", keyword); 
        model.addAttribute("categories", categories);
        model.addAttribute("sub_categories", sub_categories);
        model.addAttribute("small_categories", small_categories);
        return "product_categories"; // 適切なテンプレート名を指定する
    }
    
    @GetMapping("/products/{id}")
    public String showProductDetails(@PathVariable Long id, Model model) {
        ProductInfo productInfo = productInfoService.getProductInfoById(id);

        model.addAttribute("productInfo", productInfo);
        return "product_categories_detail"; // テンプレート名を返す
    }

    @PostMapping("/products/{id}")
    public String productOrder(@PathVariable Long id, Model model) {
        // ここで発注処理を行う（例：サービスを呼び出してデータベースに保存など）

        // 発注画面にリダイレクト
        return "redirect:/admin/products/" + id + "/order";
    }

    @GetMapping("/products/{id}/order")
    public String showOrderPage(@PathVariable Long id, Model model) {
        // URLのIDを使用して商品情報を取得
        ProductInfo productInfo = productInfoService.getProductInfoById(id);

        // ProductOrderFormの初期化
        ProductOrderForm productOrderForm = new ProductOrderForm();
        productOrderForm.setProduct_infos_id(productInfo.getId());

        // Modelに属性を追加
        model.addAttribute("productInfo", productInfo);
        model.addAttribute("productOrderForm", productOrderForm);

        return "product_order";
    }



}
