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

import co.com.hulk.store.product.services.services.ICategoryServices;
import co.com.hulk.store.products.commons.dto.CategoryDTO;

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE }, maxAge = 3600)
public class CategoryRestController {

	@Autowired
	private ICategoryServices iCategoryService;

	@GetMapping
	public List<CategoryDTO> findAll() {
		return iCategoryService.findAll();
	}

	@GetMapping("/{id}")
	public CategoryDTO findById(@PathVariable("id") String id) {
		return iCategoryService.findById(id);
	}

	@PostMapping
	public CategoryDTO save(@Valid @RequestBody CategoryDTO brand) {
		return iCategoryService.save(brand);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id")String id) {
		iCategoryService.delete(id);
	}

}
