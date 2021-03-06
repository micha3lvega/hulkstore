package co.com.hulk.store.shopping.cart.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.hulk.store.shopping.cart.services.model.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String>{

	ShoppingCart findByCustomerId(String customerId);
	
}
