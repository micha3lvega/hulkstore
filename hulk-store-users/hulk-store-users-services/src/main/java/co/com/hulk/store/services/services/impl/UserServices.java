package co.com.hulk.store.services.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.hulk.store.commons.dto.RolDTO;
import co.com.hulk.store.commons.dto.UserDTO;
import co.com.hulk.store.commons.exception.UserException;
import co.com.hulk.store.commons.exception.UserExceptionCode;
import co.com.hulk.store.services.model.Rol;
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
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {

		return repository.findAll().stream().map(user -> {
			return mapper.map(user, UserDTO.class);
		}).collect(Collectors.toList());

	}

	@Override
	@Transactional
	public UserDTO createAdministrator(UserDTO user) throws UserException {

		// Normalizar correo
		user.setEmail(user.getEmail().toLowerCase());

		// find by repeat email
		User userEmail = repository.findByEmail(user.getEmail());

		if (userEmail != null && userEmail.getRol().equals(Rol.ADMINISTRATOR)) {
			throw new UserException(UserExceptionCode.EMAIL_REPEAT_EXCEPTION);
		}

		User obj = mapper.map(user, User.class);
		obj.setPassword(passwordEncoder.encode(obj.getPassword()));
		obj.setState(UserState.ACTIVE);
		obj.setRol(Rol.ADMINISTRATOR);

		User userCreate = repository.insert(obj);
		return mapper.map(userCreate, UserDTO.class);

	}

	@Override
	@Transactional
	public UserDTO createCustomer(UserDTO user) throws UserException {

		// Normalizar correo
		user.setEmail(user.getEmail().toLowerCase());

		// find by repeat email
		User userEmail = repository.findByEmail(user.getEmail());

		if (userEmail != null && userEmail.getRol().equals(Rol.CUSTOMER)) {
			throw new UserException(UserExceptionCode.EMAIL_REPEAT_EXCEPTION);
		}

		User obj = mapper.map(user, User.class);
		obj.setPassword(passwordEncoder.encode(obj.getPassword()));
		obj.setState(UserState.ACTIVE);
		obj.setRol(Rol.CUSTOMER);

		User userCreate = repository.insert(obj);
		return mapper.map(userCreate, UserDTO.class);

	}

	@Override
	@Transactional
	public UserDTO update(UserDTO user) {

		// Normalizar correo
		user.setEmail(user.getEmail().toLowerCase());

		User obj = mapper.map(user, User.class);

		// agregar validacion para no actualizar la contraseña
		user.setPassword(user.getPassword());

		User userCreate = repository.save(obj);
		return mapper.map(userCreate, UserDTO.class);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO findById(String id) throws UserException {
		User user = repository.findById(id).orElseThrow(() -> new UserException(UserExceptionCode.USER_NO_EXITS));
		return mapper.map(user, UserDTO.class);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO login(RolDTO rol, String email, String encodedPassword) throws UserException {

		// Validar que el correo no sea nulo
		if (email == null) {
			throw new UserException(UserExceptionCode.INVALID_EMAIL);
		}

		// Normalizar correo
		email = email.toLowerCase();

		// find user by email
		User user = repository.findByEmailAndRol(email, mapper.map(rol, Rol.class));

		if (user == null) {
			throw new UserException(UserExceptionCode.USER_NO_EXITS);
		}

		// verify password
		if (passwordEncoder.matches(encodedPassword, user.getPassword())) {
			return mapper.map(user, UserDTO.class);
		}

		throw new UserException(UserExceptionCode.LOGIN_ERROR);
	}

	@Override
	@Transactional
	public UserDTO disable(String id) throws UserException {

		User user = repository.findById(id).orElseThrow(() -> new UserException(UserExceptionCode.USER_NO_EXITS));
		user.setState(UserState.INACTIVE);

		return mapper.map(repository.save(user), UserDTO.class);
	}

	@Override
	@Transactional
	public UserDTO updatePassword(String id, String newPassword) throws UserException {

		User user = repository.findById(id).orElseThrow(() -> new UserException(UserExceptionCode.USER_NO_EXITS));
		user.setPassword(passwordEncoder.encode(newPassword));

		return mapper.map(repository.save(user), UserDTO.class);
	}

	@Override
	@Transactional
	public UserDTO enable(String id) throws UserException {

		User user = repository.findById(id).orElseThrow(() -> new UserException(UserExceptionCode.USER_NO_EXITS));
		user.setState(UserState.ACTIVE);

		return mapper.map(repository.save(user), UserDTO.class);
	}

}
