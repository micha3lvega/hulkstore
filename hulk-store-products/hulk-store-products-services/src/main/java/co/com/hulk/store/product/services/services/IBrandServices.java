package co.com.hulk.store.product.services.services;

import java.util.List;

import co.com.hulk.store.products.commons.dto.BrandDTO;
import co.com.hulk.store.products.commons.exception.brand.BrandException;

public interface IBrandServices {

	List<BrandDTO> findAll();

	BrandDTO findById(String id) throws BrandException;

	BrandDTO save(BrandDTO brand) throws BrandException;

	void delete(String id) throws BrandException;

}
