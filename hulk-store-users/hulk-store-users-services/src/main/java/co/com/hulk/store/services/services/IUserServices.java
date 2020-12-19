package co.com.hulk.store.services.services;

import java.util.List;

import co.com.hulk.store.commons.dto.UserDTO;
import co.com.hulk.store.commons.exception.UserException;

public interface IUserServices {

	List<UserDTO> findAll();

	UserDTO update(UserDTO user);

	UserDTO enable(String id) throws UserException;

	UserDTO disable(String id) throws UserException;

	UserDTO findById(String id) throws UserException;

	UserDTO createCustomer(UserDTO user) throws UserException;

	UserDTO createAdministrator(UserDTO user) throws UserException;
	
	UserDTO login(String email, String encodedPassword) throws UserException;

	UserDTO updatePassword(String id, String newPassword) throws UserException;
}
