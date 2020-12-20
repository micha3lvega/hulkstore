package co.com.hulk.store.product.services.services;

import java.util.List;

import co.com.hulk.store.products.commons.dto.UnitOfMeasurementDTO;

public interface IUnitOfMeasurementServices {

	void delete(String id);

	List<UnitOfMeasurementDTO> findAll();

	UnitOfMeasurementDTO findById(String id);

	UnitOfMeasurementDTO save(UnitOfMeasurementDTO brand);

}
