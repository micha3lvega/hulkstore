package co.com.hulk.store.services.rest.controller;

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

import co.com.hulk.store.commons.dto.UserDTO;
import co.com.hulk.store.commons.exception.UserException;
import co.com.hulk.store.services.services.IUserServices;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST }, maxAge = 3600)
public class UserRestController {

	@Autowired
	private IUserServices iUserServices;

	@PostMapping
	public UserDTO create(@Valid @RequestBody UserDTO user) throws UserException {
		return iUserServices.create(user);
	}

	@GetMapping
	public List<UserDTO> findAll() {
		return iUserServices.findAll();
	}

	@PutMapping
	public UserDTO update(@Valid @RequestBody UserDTO user) {
		return iUserServices.update(user);
	}

	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable("id") String id) throws UserException {
		return iUserServices.findById(id);
	}

	@PutMapping("/disable/{id}")
	public UserDTO disable(@PathVariable("id") String id) throws UserException {
		return iUserServices.disable(id);
	}

	@PutMapping("/enable/{id}")
	public UserDTO enable(@PathVariable("id") String id) throws UserException {
		return iUserServices.enable(id);
	}

	@GetMapping("/login/{email}/{password}")
	public UserDTO login(@PathVariable("email") String email, @PathVariable("password") String password)
			throws UserException {
		return iUserServices.login(email, password);
	}

	@PutMapping("/updatePassword/{id}/{password}")
	public UserDTO updatePassword(@PathVariable("id") String id, @PathVariable("newPassword") String newPassword)
			throws UserException {
		return iUserServices.updatePassword(id, newPassword);
	}
}
