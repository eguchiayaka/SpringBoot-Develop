package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Manufacturer;
import com.example.demo.form.ManufacturerEditForm;
import com.example.demo.form.ManufacturerRegisterForm;
import com.example.demo.repository.ManufacturerRepository;
import com.example.demo.service.ManufacturerServiceImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class ManufacturerController {
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	@Autowired
    private ManufacturerServiceImpl manufacturerServiceImpl;
	
	 @GetMapping("/manufacturers")
	    public String listManufacturers(Model model) {
	        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
	        
	        model.addAttribute("manufacturers", manufacturers);
	        return "manufacturers"; // users.htmlを返す
	    }
	 
	 @GetMapping("/manufacturers/{id}")
	    public String showManufacturerDetail(@PathVariable("id") Long id, Model model) {
	        Manufacturer manufacturer = manufacturerServiceImpl.manufacturerfindById(id);
	        model.addAttribute("manufacturer", manufacturer);
	        return "manufacturer_detail";
	    }
	 
	 @PostMapping("/manufacturers/{id}")
	    public String edit(@PathVariable Long id,
	                       @RequestParam("action") String action,
	                       Model model) {
	        if ("delete".equals(action)) {
	            // 削除ボタンが押された場合の処理
	            manufacturerServiceImpl.deleteManufacturer(id);
	            return "redirect:/admin/manufacturers"; // 削除が完了したら一覧ページにリダイレクト
	       
	        } else if ("edit".equals(action)) {

	            return "redirect:/admin/manufacturers/" + id + "/edit"; // 編集が完了したら編集ページにリダイレクト
	        }
	        return "redirect:/admin/manufacturers"; // 何もせずに一覧ページにリダイレクト（本来はありえないが、安全策）
	    }
	 
	 @GetMapping("/manufacturers/{id}/edit")
	    public String showManufacturerEditForm(@PathVariable("id") Long id, Model model) {
	        Manufacturer manufacturer = manufacturerServiceImpl.manufacturerfindById(id);
	        ManufacturerEditForm manufacturerEditForm = new ManufacturerEditForm();

	        // LoginEditFormにユーザー情報を設定
	        manufacturerEditForm.setId(manufacturer.getId());
	        manufacturerEditForm.setManufacturer_name(manufacturer.getManufacturer_name());
       
	        model.addAttribute("manufacturer", manufacturer);
	        model.addAttribute("manufacturerEditForm", manufacturerEditForm);
	        return "manufacturer_edit";
	    }
	 
	 @PostMapping("/manufacturers/{id}/edit")
	    public String processManufacturEditForm(@PathVariable Long id,
	                                  @ModelAttribute @Valid ManufacturerEditForm manufacturerEditForm,
	                                  BindingResult bindingResult,
	                                  Model model) {
	        if (bindingResult.hasErrors()) {
	            bindingResult.getAllErrors().forEach(error -> System.out.println(error.toString()));
	            return "manufacturers_edit"; // バリデーションエラーがある場合は編集ページを再表示
	        }

	        manufacturerServiceImpl.updateManufacturer(id, manufacturerEditForm); // ユーザーを更新

	        // 更新後にリダイレクトするURLを指定
	        return "redirect:/admin/manufacturers/" + id; // 編集が完了したらリダイレクト
	    }
	
	 @GetMapping("/manufacturers/register")
	    public String showManufacturerRegistarForm(Model model) {
	        model.addAttribute("manufacturerRegisterForm", new ManufacturerRegisterForm());
	        return "manufacturer_register"; // テンプレートのパス
	    }

	    @PostMapping("/manufacturers/register")
	    public String registerUser(@Validated @ModelAttribute("manufacturerRegisterForm") ManufacturerRegisterForm manufacturerRegisterForm, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "manufacturer_register";
	        } else {
	            manufacturerServiceImpl.saveManufacturer(manufacturerRegisterForm);
	            return "redirect:/admin/manufacturers";
	        }
	    }
}


