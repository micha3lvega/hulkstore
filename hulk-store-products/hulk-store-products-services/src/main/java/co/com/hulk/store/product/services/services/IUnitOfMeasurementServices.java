package co.com.hulk.store.product.services.services;

import java.util.List;

import co.com.hulk.store.products.commons.dto.UnitOfMeasurementDTO;
import co.com.hulk.store.products.commons.exception.unit.of.measurement.UnitOfMeasurementException;

public interface IUnitOfMeasurementServices {

	void delete(String id) throws UnitOfMeasurementException;

	List<UnitOfMeasurementDTO> findAll();

	UnitOfMeasurementDTO findById(String id) throws UnitOfMeasurementException;

	UnitOfMeasurementDTO save(UnitOfMeasurementDTO unitOfMeasurementDTO) throws UnitOfMeasurementException;

}
