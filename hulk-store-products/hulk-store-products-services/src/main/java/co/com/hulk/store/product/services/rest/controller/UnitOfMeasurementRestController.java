package co.com.hulk.store.product.services.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.hulk.store.product.services.services.IUnitOfMeasurementServices;
import co.com.hulk.store.products.commons.dto.UnitOfMeasurementDTO;

@RestController
@RequestMapping("/api/v1/unitOfMeasurement")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE }, maxAge = 3600)
public class UnitOfMeasurementRestController {
	
	
	@Autowired
	private IUnitOfMeasurementServices service;

	@GetMapping
	public List<UnitOfMeasurementDTO> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public UnitOfMeasurementDTO findById(@PathVariable("id") String id) {
		return service.findById(id);
	}

	@PostMapping
	public UnitOfMeasurementDTO save(@Valid @RequestBody UnitOfMeasurementDTO unitOfMeasurement) {
		return service.save(unitOfMeasurement);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}

}
