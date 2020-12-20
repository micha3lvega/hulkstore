package co.com.hulk.store.product.services.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.hulk.store.product.services.model.UnitOfMeasurement;
import co.com.hulk.store.product.services.repository.UnitOfMeasurementRepository;
import co.com.hulk.store.product.services.services.IUnitOfMeasurementServices;
import co.com.hulk.store.products.commons.dto.UnitOfMeasurementDTO;

@Service
public class UnitOfMeasurementServices implements IUnitOfMeasurementServices {

	@Autowired
	private UnitOfMeasurementRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public void delete(String id) {

		UnitOfMeasurement unitOfMeasurement = repository.findById(id).orElse(null);

		if (unitOfMeasurement == null) {
			return;
		}

		repository.delete(unitOfMeasurement);

	}

	@Override
	public List<UnitOfMeasurementDTO> findAll() {
		return repository.findAll().stream().map(unitOfMeasurement -> {
			return mapper.map(unitOfMeasurement, UnitOfMeasurementDTO.class);
		}).collect(Collectors.toList());
	}

	@Override
	public UnitOfMeasurementDTO findById(String id) {

		UnitOfMeasurement unitOfMeasurement = repository.findById(id).orElse(null);

		if (unitOfMeasurement == null) {
			return null;
		}

		return mapper.map(unitOfMeasurement, UnitOfMeasurementDTO.class);
	}

	@Override
	public UnitOfMeasurementDTO save(UnitOfMeasurementDTO unitOfMeasurementDTO) {

		UnitOfMeasurement unitOfMeasurement = repository.save(mapper.map(unitOfMeasurementDTO, UnitOfMeasurement.class));		
		return mapper.map(unitOfMeasurement, UnitOfMeasurementDTO.class);
		
	}

}
