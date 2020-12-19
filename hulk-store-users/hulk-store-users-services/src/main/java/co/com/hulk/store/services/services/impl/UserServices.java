package co.com.hulk.store.services.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.com.hulk.store.commons.dto.UserDTO;
import co.com.hulk.store.commons.exception.UserException;
import co.com.hulk.store.commons.exception.UserExceptionCode;
import co.com.hulk.store.services.model.User;
import co.com.hulk.store.services.model.UserState;
import co.com.hulk.store.services.repository.UserRepository;
import co.com.hulk.store.services.services.IUserServices;

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
	public UserDTO create(UserDTO user) throws UserException {

		// find by repeat email
		User userEmail = repository.findByEmail(user.getEmail());

		if (userEmail != null) {
			throw new UserException(UserExceptionCode.EMAIL_REPEAT_EXCEPTION);
		}

		User obj = mapper.map(user, User.class);
		obj.setPassword(passwordEncoder.encode(obj.getPassword()));
		obj.setState(UserState.ACTIVE);

		User userCreate = repository.insert(obj);
		return mapper.map(userCreate, UserDTO.class);

	}

	@Override
	public UserDTO update(UserDTO user) {
		User obj = mapper.map(user, User.class);
		User userCreate = repository.save(obj);
		return mapper.map(userCreate, UserDTO.class);
	}

	@Override
	public UserDTO findById(String id) throws UserException {
		User user = repository.findById(id).orElseThrow(() -> new UserException(UserExceptionCode.USER_NO_EXITS));
		return mapper.map(user, UserDTO.class);
	}

	@Override
	public UserDTO login(String email, String encodedPassword) throws UserException {

		// find user by email
		User user = repository.findByEmail(email);

		if (user == null) {
			throw new UserException(UserExceptionCode.USER_NO_EXITS);
		}

		// verify password
		if (passwordEncoder.matches(encodedPassword, user.getPassword())) {
			return mapper.map(user, UserDTO.class);
		}

		return null;
	}

	@Override
	public UserDTO disable(String id) throws UserException {

		User user = repository.findById(id).orElseThrow(() -> new UserException(UserExceptionCode.USER_NO_EXITS));
		user.setState(UserState.INACTIVE);

		return mapper.map(repository.save(user), UserDTO.class);
	}

	@Override
	public UserDTO updatePassword(String id, String newPassword) throws UserException {
		
		User user = repository.findById(id).orElseThrow(() -> new UserException(UserExceptionCode.USER_NO_EXITS));
		user.setPassword(passwordEncoder.encode(newPassword));
		
		return mapper.map(repository.save(user), UserDTO.class);
	}

	@Override
	public UserDTO enable(String id) throws UserException {
		
		User user = repository.findById(id).orElseThrow(() -> new UserException(UserExceptionCode.USER_NO_EXITS));
		user.setState(UserState.ACTIVE);

		return mapper.map(repository.save(user), UserDTO.class);
	}

}
