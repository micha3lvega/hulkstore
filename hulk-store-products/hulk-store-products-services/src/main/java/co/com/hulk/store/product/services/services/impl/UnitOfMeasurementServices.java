package co.com.hulk.store.product.services.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.hulk.store.product.services.model.UnitOfMeasurement;
import co.com.hulk.store.product.services.repository.UnitOfMeasurementRepository;
import co.com.hulk.store.product.services.services.IUnitOfMeasurementServices;
import co.com.hulk.store.product.services.util.Util;
import co.com.hulk.store.products.commons.dto.UnitOfMeasurementDTO;
import co.com.hulk.store.products.commons.exception.unit.of.measurement.UnitOfMeasurementCodeException;
import co.com.hulk.store.products.commons.exception.unit.of.measurement.UnitOfMeasurementException;

@Service
public class UnitOfMeasurementServices implements IUnitOfMeasurementServices {

	@Autowired
	private UnitOfMeasurementRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Override
	@Transactional
	public void delete(String id) throws UnitOfMeasurementException {

		UnitOfMeasurement unitOfMeasurement = repository.findById(id).orElseThrow(
				() -> new UnitOfMeasurementException(UnitOfMeasurementCodeException.UNIT_OF_MEASUREMENT_NO_EXISTS));
		repository.delete(unitOfMeasurement);

	}

	@Override
	@Transactional(readOnly = true)
	public List<UnitOfMeasurementDTO> findAll() {
		return repository.findAll().stream().map(unitOfMeasurement -> {
			return mapper.map(unitOfMeasurement, UnitOfMeasurementDTO.class);
		}).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public UnitOfMeasurementDTO findById(String id) throws UnitOfMeasurementException {
		
		UnitOfMeasurement unitOfMeasurement = repository.findById(id).orElseThrow(
				() -> new UnitOfMeasurementException(UnitOfMeasurementCodeException.UNIT_OF_MEASUREMENT_NO_EXISTS));
		return mapper.map(unitOfMeasurement, UnitOfMeasurementDTO.class);
		
	}

	@Override
	@Transactional
	public UnitOfMeasurementDTO save(UnitOfMeasurementDTO unitOfMeasurementDTO) throws UnitOfMeasurementException {
		
		// Normalizar el nombre
		unitOfMeasurementDTO.setName(Util.capitalizeString(unitOfMeasurementDTO.getName()));
		
		// Buscar si ya existe una unidad de medida con el nombre dado
		UnitOfMeasurement findUnitOfMeasurement = repository.findByName(unitOfMeasurementDTO.getName());
		
		if (unitOfMeasurementDTO.getId() != null) {
			
			if (findUnitOfMeasurement != null && !findUnitOfMeasurement.getName().equals(unitOfMeasurementDTO.getName())) {
				throw new UnitOfMeasurementException(UnitOfMeasurementCodeException.UNIT_OF_MEASUREMENT_ALREADY_EXISTS);
			}
			
			UnitOfMeasurement unitOfMeasurement = repository
					.save(mapper.map(unitOfMeasurementDTO, UnitOfMeasurement.class));
			return mapper.map(unitOfMeasurement, UnitOfMeasurementDTO.class);
		}
		
		if (findUnitOfMeasurement != null) {
			throw new UnitOfMeasurementException(UnitOfMeasurementCodeException.UNIT_OF_MEASUREMENT_ALREADY_EXISTS);
		}

		UnitOfMeasurement unitOfMeasurement = repository
				.insert(mapper.map(unitOfMeasurementDTO, UnitOfMeasurement.class));
		return mapper.map(unitOfMeasurement, UnitOfMeasurementDTO.class);

	}

}
