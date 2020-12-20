package co.com.hulk.store.product.services.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.hulk.store.product.services.model.Category;
import co.com.hulk.store.product.services.repository.CategoryRepository;
import co.com.hulk.store.product.services.services.ICategoryServices;
import co.com.hulk.store.product.services.util.Util;
import co.com.hulk.store.products.commons.dto.CategoryDTO;
import co.com.hulk.store.products.commons.exception.category.CategoryCodeException;
import co.com.hulk.store.products.commons.exception.category.CategoryException;

@Service
public class CategoryServices implements ICategoryServices {

	@Autowired
	private CategoryRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Override
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		return repository.findAll().stream().map(category -> {
			return mapper.map(category, CategoryDTO.class);
		}).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public CategoryDTO findById(String id) throws CategoryException {

		Category category = repository.findById(id)
				.orElseThrow(() -> new CategoryException(CategoryCodeException.CATEGORY_NO_EXISTS));
		return mapper.map(category, CategoryDTO.class);

	}

	@Override
	@Transactional
	public CategoryDTO save(CategoryDTO dto) throws CategoryException {

		// Normalizar el nombre
		dto.setName(Util.capitalizeString(dto.getName()));

		// Buscar si ya existe una categoria con ese nombre
		Category findCategory = repository.findByName(dto.getName());

		if (dto.getId() == null) {

			if (findCategory != null && !findCategory.getName().equals(dto.getName())) {
				throw new CategoryException(CategoryCodeException.CATEGORY_ALREADY_EXISTS);
			}

			Category obj = repository.insert(mapper.map(dto, Category.class));
			return mapper.map(obj, CategoryDTO.class);
		}

		if (findCategory != null) {
			throw new CategoryException(CategoryCodeException.CATEGORY_ALREADY_EXISTS);
		}

		Category obj = repository.save(mapper.map(dto, Category.class));
		return mapper.map(obj, CategoryDTO.class);

	}

	@Override
	@Transactional
	public void delete(String id) throws CategoryException {

		Category category = repository.findById(id)
				.orElseThrow(() -> new CategoryException(CategoryCodeException.CATEGORY_NO_EXISTS));
		repository.delete(category);

	}

}
