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
import co.com.hulk.store.products.commons.dto.BrandDTO;

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
	public BrandDTO findById(String id) {

		Brand brand = repository.findById(id).orElse(null);

		if (brand == null) {
			return null;
		}

		return mapper.map(brand, BrandDTO.class);
	}

	@Override
	@Transactional
	public BrandDTO save(BrandDTO brand) {

		if (brand.getId() != null) {
			Brand obj = repository.save(mapper.map(brand, Brand.class));
			return mapper.map(obj, BrandDTO.class);
		}
		
		Brand obj = repository.insert(mapper.map(brand, Brand.class));
		return mapper.map(obj, BrandDTO.class);

	}

	@Override
	@Transactional
	public void delete(String id) {

		Brand brand = repository.findById(id).orElse(null);

		if (brand == null) {
			return;
		}

		repository.delete(brand);
	}

}
