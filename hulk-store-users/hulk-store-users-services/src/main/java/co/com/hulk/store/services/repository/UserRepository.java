package co.com.hulk.store.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.hulk.store.services.model.Rol;
import co.com.hulk.store.services.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);

	User findByEmailAndRol(String email, Rol rol);
}
