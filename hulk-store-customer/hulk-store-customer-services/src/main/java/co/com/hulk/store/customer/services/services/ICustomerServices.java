package co.com.hulk.store.customer.services.services;

import java.util.List;

import co.com.hulk.store.customer.commons.dto.CustomerDTO;
import co.com.hulk.store.customer.commons.exception.CustomerException;

public interface ICustomerServices {

	List<CustomerDTO> findAll();

	CustomerDTO findById(String id) throws CustomerException;

	CustomerDTO insert(CustomerDTO customer) throws CustomerException;

	CustomerDTO update(CustomerDTO customer) throws CustomerException;

}
