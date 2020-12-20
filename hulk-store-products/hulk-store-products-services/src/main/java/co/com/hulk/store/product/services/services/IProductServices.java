package co.com.hulk.store.product.services.services;

import java.util.List;

import co.com.hulk.store.products.commons.dto.ProductDTO;

public interface IProductServices {

	List<ProductDTO> findAll();

	ProductDTO findById(String id);

	ProductDTO create(ProductDTO dto);

	ProductDTO update(ProductDTO dto);

}
