package co.com.hulk.store.product.services.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.hulk.store.product.services.services.IProductServices;
import co.com.hulk.store.products.commons.dto.ProductDTO;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE }, maxAge = 3600)
public class ProductRestController {

	@Autowired
	private IProductServices service;

	@GetMapping
	public List<ProductDTO> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ProductDTO findById(@PathVariable("id") String id) {
		return service.findById(id);
	}
	
	@PostMapping
	public ProductDTO create(@Valid @RequestBody ProductDTO dto) {
		return service.create(dto);
	}
	
	@PutMapping
	public ProductDTO update(ProductDTO dto) {
		return service.update(dto);
	}
}
