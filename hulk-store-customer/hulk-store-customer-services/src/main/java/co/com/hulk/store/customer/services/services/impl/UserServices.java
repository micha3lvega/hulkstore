package co.com.hulk.store.customer.services.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.hulk.store.commons.dto.UserDTO;
import co.com.hulk.store.commons.exception.UserException;
import co.com.hulk.store.customer.services.rest.client.UserRestClient;
import co.com.hulk.store.customer.services.services.IUserServices;

@Service
public class UserServices implements IUserServices {
	
	@Autowired
	private UserRestClient client; 

	@Override
	public List<UserDTO> findAll() {
		return client.findAll();
	}

	@Override
	public UserDTO enable(String id) throws UserException {
		return client.enable(id);
	}

	@Override
	public UserDTO disable(String id) throws UserException {
		return client.disable(id);
	}

	@Override
	public UserDTO findById(String id) throws UserException {
		return client.findById(id);
	}

	@Override
	public UserDTO update(UserDTO user) throws UserException {
		return client.update(user);
	}

	@Override
	public UserDTO create(UserDTO user) throws UserException {
		return client.create(user);
	}

	@Override
	public UserDTO login(String email, String encodedPassword) throws UserException {
		return client.login(email, encodedPassword);
	}

	@Override
	public UserDTO updatePassword(String id, String newPassword) throws UserException {
		return client.updatePassword(id, newPassword);
	}

}
