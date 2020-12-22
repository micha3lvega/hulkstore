package co.com.hulk.store.shopping.cart.services.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.hulk.store.customer.commons.dto.CustomerDTO;
import co.com.hulk.store.customer.commons.exception.CustomerException;
import co.com.hulk.store.shopping.cart.services.rest.client.CustomerRestClient;
import co.com.hulk.store.shopping.cart.services.services.ICustomerServices;

@Service
public class CustomerServices implements ICustomerServices{
	
	@Autowired
	private CustomerRestClient restClient;

	@Override
	public CustomerDTO findById(String id) throws CustomerException {
		return restClient.findById(id);
	}

}
