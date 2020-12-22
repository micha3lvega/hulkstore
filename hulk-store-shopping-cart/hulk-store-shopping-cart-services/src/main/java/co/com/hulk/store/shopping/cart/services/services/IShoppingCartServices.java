package co.com.hulk.store.shopping.cart.services.services;

import java.util.List;

import co.com.hulk.store.shopping.cart.dto.ItemDTO;
import co.com.hulk.store.shopping.cart.dto.ShoppingCartDTO;

public interface IShoppingCartServices {

	void delete(String id);
	
	ShoppingCartDTO findByCustomer(String customerId);

	ShoppingCartDTO update(String id, List<ItemDTO> items);

	ShoppingCartDTO create(String customer, List<ItemDTO> items);

}
