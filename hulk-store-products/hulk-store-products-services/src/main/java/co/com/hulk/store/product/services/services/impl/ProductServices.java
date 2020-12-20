package co.com.hulk.store.product.services.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.hulk.store.product.services.model.Product;
import co.com.hulk.store.product.services.repository.ProductRepository;
import co.com.hulk.store.product.services.services.IProductServices;
import co.com.hulk.store.product.services.util.Util;
import co.com.hulk.store.products.commons.dto.ProductDTO;
import co.com.hulk.store.products.commons.exception.ProductCodeException;
import co.com.hulk.store.products.commons.exception.ProductException;

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
	public ProductDTO findById(String id) throws ProductException {

		Product product = repository.findById(id).orElseThrow(() -> new ProductException(ProductCodeException.PRODUCT_NO_EXISTS));

		if (product == null) {
			return null;
		}

		return mapper.map(product, ProductDTO.class);
	}

	@Override
	public ProductDTO create(ProductDTO dto) throws ProductException {
		
		//Normalizar el nombre
		dto.setName(Util.capitalizeString(dto.getName()));
		
		//Buscar si existe el producto
		Product findProduct = repository.findByName(dto.getName());
		
		if (findProduct != null) {
			throw new ProductException(ProductCodeException.PRODUCT_ALREADY_EXISTS);
		}
				
		Product product = mapper.map(dto, Product.class);
		product = repository.insert(product);

		return mapper.map(product, ProductDTO.class);

	}

	@Override
	public ProductDTO update(ProductDTO dto) throws ProductException {

		Product product = mapper.map(dto, Product.class);
		product = repository.save(product);

		return mapper.map(product, ProductDTO.class);

	}

}
