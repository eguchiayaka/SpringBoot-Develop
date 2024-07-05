package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Manufacturer;
import com.example.demo.form.ManufacturerEditForm;
import com.example.demo.form.ManufacturerRegisterForm;
import com.example.demo.repository.ManufacturerRepository;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

@Autowired
private ManufacturerRepository manufacturerRepository;

public void updateManufacturer(Long ManufacturerId, ManufacturerEditForm manufacturerEditForm) {
	Manufacturer manufacturer  = manufacturerRepository.findById(ManufacturerId).orElse(new Manufacturer());

	manufacturer.setId(ManufacturerId);
	manufacturer.setManufacturer_name(manufacturerEditForm.getManufacturer_name());
	manufacturer.setUpdatedAt(LocalDateTime.now());

	if (manufacturer.getCreatedAt() == null) {
		manufacturer.setCreatedAt(LocalDateTime.now());
	}
	manufacturer.setUpdatedAt(LocalDateTime.now());

	manufacturerRepository.save(manufacturer);
}

public Manufacturer saveManufacturer(ManufacturerRegisterForm manufacturerRegisterForm) {
    // TODO 自動生成されたメソッド・スタブ
    Manufacturer manufacturer = new Manufacturer();
    manufacturer.setId(manufacturerRegisterForm.getId());
    manufacturer.setManufacturer_name(manufacturerRegisterForm.getManufacturer_name());

    return manufacturerRepository.save(manufacturer);
}

public void deleteManufacturer(Long id) {
	manufacturerRepository.deleteById(id);
	// TODO 自動生成されたメソッド・スタブ
	
}

public Manufacturer manufacturerfindById(Long id) {
	return manufacturerRepository.findById(id).orElse(null);
}

public Manufacturer getManufacturerById(Long manufacturerId) {
return manufacturerRepository.getManufacturerById(manufacturerId).orElse(null);
}
}

