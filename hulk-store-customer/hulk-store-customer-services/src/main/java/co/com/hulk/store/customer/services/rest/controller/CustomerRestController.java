package co.com.hulk.store.customer.services.rest.controller;

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

import co.com.hulk.store.customer.commons.dto.CustomerDTO;
import co.com.hulk.store.customer.commons.exception.CustomerException;
import co.com.hulk.store.customer.services.services.ICustomerServices;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT }, maxAge = 3600)
public class CustomerRestController {

	@Autowired
	private ICustomerServices customerServices;

	@GetMapping
	public List<CustomerDTO> findAll() {
		return customerServices.findAll();
	}

	@GetMapping("/{id}")
	public CustomerDTO findById(@PathVariable("id") String id) throws CustomerException {
		return customerServices.findById(id);
	}

	@PostMapping
	public CustomerDTO insert(@Valid @RequestBody CustomerDTO customer) throws CustomerException {
		return customerServices.insert(customer);
	}

	@PutMapping
	public CustomerDTO update(@Valid @RequestBody CustomerDTO customer) throws CustomerException {
		return customerServices.update(customer);
	}

}
