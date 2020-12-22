package co.com.hulk.store.shopping.cart.services.services;

import co.com.hulk.store.customer.commons.dto.CustomerDTO;
import co.com.hulk.store.customer.commons.exception.CustomerException;

public interface ICustomerServices {
	
	public CustomerDTO findById(String id) throws CustomerException;

}
