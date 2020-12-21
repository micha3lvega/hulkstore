package co.com.hulk.store.customer.services;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.hulk.store.customer.services.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

}
