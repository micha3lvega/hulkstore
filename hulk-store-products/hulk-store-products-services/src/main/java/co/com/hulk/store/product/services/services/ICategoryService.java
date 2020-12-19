package co.com.hulk.store.product.services.services;

import java.util.List;

import co.com.hulk.store.products.commons.dto.CategoryDTO;

public interface ICategoryService {

	List<CategoryDTO> findAll();

	CategoryDTO findById(String id);

	CategoryDTO save(CategoryDTO category);

	void delete(String id);

}
