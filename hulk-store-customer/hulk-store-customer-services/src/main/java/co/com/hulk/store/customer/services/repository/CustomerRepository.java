package co.com.hulk.store.customer.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.hulk.store.customer.services.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

}
