package com.example.demo.service;

import com.example.demo.entity.Manufacturer;
import com.example.demo.form.ManufacturerEditForm;
import com.example.demo.form.ManufacturerRegisterForm;

public interface ManufacturerService {

	void updateManufacturer(Long ManufacturerId, ManufacturerEditForm manufacturerEditForm) ;
	 Manufacturer saveManufacturer(ManufacturerRegisterForm manufacturerRegisterForm) ;
	 void deleteManufacturer(Long id);
	 Manufacturer manufacturerfindById(Long id);
	Manufacturer getManufacturerById(Long manufacturerId);
}
