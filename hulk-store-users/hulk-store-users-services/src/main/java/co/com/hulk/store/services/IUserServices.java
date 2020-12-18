package co.com.hulk.store.services;

import java.util.List;

import co.com.hulk.store.commons.dto.UserDTO;

public interface IUserServices {

	List<UserDTO> findAll();
	
	UserDTO create(UserDTO user);

	UserDTO update(UserDTO user);

	UserDTO findById(String id);
	
	UserDTO login(String email, String encodedPassword);
}
