package co.com.hulk.store.shopping.cart.services.rest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.com.hulk.store.customer.commons.dto.CustomerDTO;
import co.com.hulk.store.customer.commons.exception.CustomerException;

@FeignClient(value = "customers", url = "http://localhost:8093/api/v1/customer")
public interface CustomerRestClient {

	@GetMapping("/{id}")
	public CustomerDTO findById(@PathVariable("id") String id) throws CustomerException;

}
