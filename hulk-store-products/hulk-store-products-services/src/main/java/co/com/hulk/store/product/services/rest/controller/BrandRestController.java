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

import co.com.hulk.store.product.services.services.IBrandServices;
import co.com.hulk.store.products.commons.dto.BrandDTO;

@RestController
@RequestMapping("/api/v1/brand")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE }, maxAge = 3600)
public class BrandRestController {

	@Autowired
	private IBrandServices brandServices;

	@GetMapping
	public List<BrandDTO> findAll() {
		return brandServices.findAll();
	}

	@GetMapping("/{id}")
	public BrandDTO findById(@PathVariable("id") String id) {
		return brandServices.findById(id);
	}

	@PostMapping
	public BrandDTO save(@Valid @RequestBody BrandDTO brand) {
		return brandServices.save(brand);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		brandServices.delete(id);
	}
}
