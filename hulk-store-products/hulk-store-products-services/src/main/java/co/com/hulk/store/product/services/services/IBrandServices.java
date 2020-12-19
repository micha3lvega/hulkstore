package co.com.hulk.store.product.services.services;

import java.util.List;

import co.com.hulk.store.products.commons.dto.BrandDTO;

public interface IBrandServices {
	
	List<BrandDTO> findAll();
	
	BrandDTO findById(String id);
	
	BrandDTO save(BrandDTO brand);
	
	void delete(String id);

}
