package co.com.hulk.store.services;

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

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST }, maxAge = 3600)
public class UserRestController {

	@Autowired
	private IUserServices iUserServices;
	
	@PostMapping
	public UserDTO create(@Valid @RequestBody UserDTO user) {
		return iUserServices.create(user);
	}
	
	@GetMapping
	public List<UserDTO> findAll(){
		return iUserServices.findAll();
	}
	
	@PutMapping
	public UserDTO update(@Valid @RequestBody UserDTO user) {
		return iUserServices.update(user);
	}
	
	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable("id") String id) {
		return iUserServices.findById(id);
	}
	
	@GetMapping("/login/{email}/{password}")
	public UserDTO login(@PathVariable("email") String email, @PathVariable("password") String password) {
		return iUserServices.login(email, password);
	}
}
