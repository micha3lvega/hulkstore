package co.com.hulk.store.product.services.services;

import java.util.List;

import co.com.hulk.store.products.commons.dto.ProductDTO;
import co.com.hulk.store.products.commons.exception.product.ProductException;

public interface IProductServices {

	List<ProductDTO> findAll();

	ProductDTO findById(String id) throws ProductException;

	ProductDTO create(ProductDTO dto) throws ProductException;

	ProductDTO update(ProductDTO dto) throws ProductException;

}
