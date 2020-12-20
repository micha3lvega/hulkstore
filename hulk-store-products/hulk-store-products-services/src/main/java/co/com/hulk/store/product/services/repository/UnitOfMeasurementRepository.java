package co.com.hulk.store.product.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.com.hulk.store.product.services.model.UnitOfMeasurement;

public interface UnitOfMeasurementRepository extends MongoRepository<UnitOfMeasurement, String> {

	UnitOfMeasurement findByName(String name);

}
