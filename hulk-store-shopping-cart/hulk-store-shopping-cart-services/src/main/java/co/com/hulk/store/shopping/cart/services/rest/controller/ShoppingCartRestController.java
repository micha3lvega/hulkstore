package co.com.hulk.store.shopping.cart.services.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.hulk.store.shopping.cart.dto.ItemDTO;
import co.com.hulk.store.shopping.cart.dto.ShoppingCartDTO;
import co.com.hulk.store.shopping.cart.services.services.IShoppingCartServices;

@RestController
@RequestMapping("/api/v1/shopping/cart")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE }, maxAge = 3600)
public class ShoppingCartRestController {

	@Autowired
	private IShoppingCartServices services;

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		services.delete(id);
	}

	@GetMapping("/{customerId}")
	public ShoppingCartDTO findByCustomer(@PathVariable("customerId") String customerId) {
		return services.findByCustomer(customerId);
	}

	@PutMapping("/{id}")
	public ShoppingCartDTO update(String id, @Valid @RequestBody List<ItemDTO> items) {
		return services.update(id, items);
	}

	@PostMapping("/{customer}")
	public ShoppingCartDTO create(@PathVariable("customer") String customer, @Valid @RequestBody List<ItemDTO> items) {
		return services.create(customer, items);
	}
}
