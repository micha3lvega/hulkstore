package co.com.hulk.store.services;

import java.util.List;

import co.com.hulk.store.commons.dto.UserDTO;
import co.com.hulk.store.services.model.User;

public interface IUserServices {

	List<UserDTO> findAll();
	
	UserDTO create(User user);

	UserDTO update(User user);

	UserDTO findById(String id);
	
	UserDTO login(String email, String encodedPassword);
}
