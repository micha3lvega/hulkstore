package co.com.hulk.store.product.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.hulk.store.product.services.model.Brand;

public interface BrandRepository extends MongoRepository<Brand, String> {

}
