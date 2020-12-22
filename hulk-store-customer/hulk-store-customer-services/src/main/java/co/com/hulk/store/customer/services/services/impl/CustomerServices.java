package co.com.hulk.store.customer.services.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.hulk.store.commons.dto.UserDTO;
import co.com.hulk.store.commons.exception.UserException;
import co.com.hulk.store.customer.commons.dto.CustomerDTO;
import co.com.hulk.store.customer.commons.exception.CustomerException;
import co.com.hulk.store.customer.commons.exception.CustomerExceptionCode;
import co.com.hulk.store.customer.services.model.Customer;
import co.com.hulk.store.customer.services.repository.CustomerRepository;
import co.com.hulk.store.customer.services.services.ICustomerServices;
import co.com.hulk.store.customer.services.services.IUserServices;

@Service
public class CustomerServices implements ICustomerServices {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private IUserServices userServices;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<CustomerDTO> findAll() {
		return repository.findAll().stream().map(customer -> {
			return mapper.map(customer, CustomerDTO.class);
		}).collect(Collectors.toList());
	}

	@Override
	public CustomerDTO findById(String id) throws CustomerException {

		Customer customer = repository.findById(id)
				.orElseThrow(() -> new CustomerException(CustomerExceptionCode.CUSTOMER_NO_EXITS));
		return mapper.map(customer, CustomerDTO.class);

	}

	@Override
	public CustomerDTO insert(CustomerDTO customer) throws CustomerException {

		try {

			// Crear el usuario
			UserDTO user = userServices.create(customer.getUser());
			customer.setUser(user);

			Customer obj = mapper.map(customer, Customer.class);
			return mapper.map(repository.insert(obj), CustomerDTO.class);

		} catch (UserException e) {
			throw new CustomerException(e.getMessage());
		}

	}

	@Override
	public CustomerDTO update(CustomerDTO customer) throws CustomerException {

		try {

			// Verificar que la entidad tenga el id
			if (customer == null || customer.getId() == null) {
				throw new CustomerException(CustomerExceptionCode.CUSTOMER_NO_EXITS);
			}

			// Buscar el cliente
			Customer findCustomer = repository.findById(customer.getId()).orElse(null);
			
			// Si el cliente no existe retorna excepcion
			if (findCustomer == null) {
				throw new CustomerException(CustomerExceptionCode.CUSTOMER_NO_EXITS);
			}

			// Actualizar el usuario
			UserDTO user = userServices.update(customer.getUser());
			customer.setUser(user);

			Customer obj = mapper.map(customer, Customer.class);
			return mapper.map(repository.save(obj), CustomerDTO.class);

		} catch (UserException e) {
			throw new CustomerException(e.getMessage());
		}

	}

}
