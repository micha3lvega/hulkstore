package co.com.hulk.store.services.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.com.hulk.store.commons.dto.UserDTO;
import co.com.hulk.store.services.IUserServices;
import co.com.hulk.store.services.model.User;
import co.com.hulk.store.services.repository.UserRepository;

@Service
public class UserServices implements IUserServices {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<UserDTO> findAll() {

		return repository.findAll().stream().map(user -> {
			return mapper.map(user, UserDTO.class);
		}).collect(Collectors.toList());

	}

	@Override
	public UserDTO create(User user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		User userCreate = repository.insert(user);
		return mapper.map(userCreate, UserDTO.class);

	}

	@Override
	public UserDTO update(User user) {
		User userCreate = repository.save(user);
		return mapper.map(userCreate, UserDTO.class);
	}

	@Override
	public UserDTO findById(String id) {
		User user = repository.findById(id).orElse(null);
		return mapper.map(user, UserDTO.class);
	}

	@Override
	public UserDTO login(String email, String encodedPassword) {

		// find user by email
		User user = repository.findByEmail(email);

		if (user == null) {
			return null;
		}

		// verify password
		if (passwordEncoder.matches(user.getPassword(), encodedPassword)) {
			return mapper.map(user, UserDTO.class);
		}

		return null;
	}

}
