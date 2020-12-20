package co.com.hulk.store.product.services.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.hulk.store.product.services.model.Brand;
import co.com.hulk.store.product.services.repository.BrandRepository;
import co.com.hulk.store.product.services.services.IBrandServices;
import co.com.hulk.store.product.services.util.Util;
import co.com.hulk.store.products.commons.dto.BrandDTO;
import co.com.hulk.store.products.commons.exception.brand.BrandCodeException;
import co.com.hulk.store.products.commons.exception.brand.BrandException;

@Service
public class BrandServices implements IBrandServices {

	@Autowired
	private BrandRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Override
	@Transactional(readOnly = true)
	public List<BrandDTO> findAll() {
		return repository.findAll().stream().map(brand -> {
			return mapper.map(brand, BrandDTO.class);
		}).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public BrandDTO findById(String id) throws BrandException {

		Brand brand = repository.findById(id).orElseThrow(() -> new BrandException(BrandCodeException.BRAND_NO_EXISTS));

		if (brand == null) {
			return null;
		}

		return mapper.map(brand, BrandDTO.class);
	}

	@Override
	@Transactional
	public BrandDTO save(BrandDTO brand) throws BrandException {

		// Normalizar el nombre
		brand.setName(Util.capitalizeString(brand.getName()));

		// Buscar si ya existe una marca con el nombre dado
		Brand findBrand = repository.findByName(brand.getName());

		if (brand.getId() != null) {

			if (findBrand != null && !findBrand.getName().equals(brand.getName())) {
				throw new BrandException(BrandCodeException.BRAND_ALREADY_EXISTS);
			}

			Brand obj = repository.save(mapper.map(brand, Brand.class));
			return mapper.map(obj, BrandDTO.class);

		}

		if (findBrand != null) {
			throw new BrandException(BrandCodeException.BRAND_ALREADY_EXISTS);
		}

		Brand obj = repository.insert(mapper.map(brand, Brand.class));
		return mapper.map(obj, BrandDTO.class);

	}

	@Override
	@Transactional
	public void delete(String id) throws BrandException {

		Brand brand = repository.findById(id).orElseThrow(() -> new BrandException(BrandCodeException.BRAND_NO_EXISTS));
		repository.delete(brand);

	}

}
