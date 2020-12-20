package co.com.hulk.store.product.services.services;

import java.util.List;

import co.com.hulk.store.products.commons.dto.CategoryDTO;
import co.com.hulk.store.products.commons.exception.category.CategoryException;

public interface ICategoryServices {

	List<CategoryDTO> findAll();

	CategoryDTO findById(String id) throws CategoryException;

	CategoryDTO save(CategoryDTO category) throws CategoryException;

	void delete(String id) throws CategoryException;

}
