package co.com.hulk.store.product.services.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.hulk.store.product.services.model.Product;
import co.com.hulk.store.product.services.repository.ProductRepository;
import co.com.hulk.store.product.services.services.IProductServices;
import co.com.hulk.store.products.commons.dto.ProductDTO;

@Service
public class ProductServices implements IProductServices {

	@Autowired
	private ProductRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<ProductDTO> findAll() {
		return repository.findAll().stream().map(product -> {
			return mapper.map(product, ProductDTO.class);
		}).collect(Collectors.toList());
	}

	@Override
	public ProductDTO findById(String id) {

		Product product = repository.findById(id).orElse(null);

		if (product == null) {
			return null;
		}

		return mapper.map(product, ProductDTO.class);
	}

	@Override
	public ProductDTO create(ProductDTO dto) {

		Product product = mapper.map(dto, Product.class);
		product = repository.insert(product);
		
		return mapper.map(product, ProductDTO.class);

	}

	@Override
	public ProductDTO update(ProductDTO dto) {
		
		Product product = mapper.map(dto, Product.class);
		product = repository.save(product);
		
		return mapper.map(product, ProductDTO.class);
		
	}

}
