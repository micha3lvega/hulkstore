package co.com.hulk.store.customer.services.rest.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.com.hulk.store.commons.dto.UserDTO;
import co.com.hulk.store.commons.exception.UserException;

@FeignClient(value = "users", url = "http://localhost:8090/api/v1/user")
public interface UserRestClient {

	@PostMapping
	public UserDTO create(@RequestBody UserDTO user) throws UserException;

	@GetMapping
	public List<UserDTO> findAll();

	@PutMapping
	public UserDTO update(@RequestBody UserDTO user) throws UserException;

	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable("id") String id) throws UserException;

	@PutMapping("/disable/{id}")
	public UserDTO disable(@PathVariable("id") String id) throws UserException;

	@PutMapping("/enable/{id}")
	public UserDTO enable(@PathVariable("id") String id) throws UserException;

	@GetMapping("/login/{email}/{password}")
	public UserDTO login(@PathVariable("email") String email, @PathVariable("password") String password)
			throws UserException;

	@PutMapping("/updatePassword/{id}/{newPassword}")
	public UserDTO updatePassword(@PathVariable("id") String id, @PathVariable("newPassword") String newPassword)
			throws UserException;

}
