package co.com.hulk.store.product.services.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.hulk.store.product.services.model.Category;
import co.com.hulk.store.product.services.repository.CategoryRepository;
import co.com.hulk.store.product.services.services.ICategoryService;
import co.com.hulk.store.products.commons.dto.CategoryDTO;

@Service
public class CategoryServices implements ICategoryService {

	@Autowired
	private CategoryRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<CategoryDTO> findAll() {
		return repository.findAll().stream().map(category -> {
			return mapper.map(category, CategoryDTO.class);
		}).collect(Collectors.toList());
	}

	@Override
	public CategoryDTO findById(String id) {

		Category category = repository.findById(id).orElse(null);

		if (category == null) {
			return null;
		}

		return mapper.map(category, CategoryDTO.class);
	}

	@Override
	public CategoryDTO save(CategoryDTO dto) {

		Category obj = repository.save(mapper.map(dto, Category.class));
		return mapper.map(obj, CategoryDTO.class);
		
	}

	@Override
	public void delete(String id) {

		Category category = repository.findById(id).orElse(null);

		if (category == null) {
			return ;
		}
		
		repository.delete(category);
	}
	
}
