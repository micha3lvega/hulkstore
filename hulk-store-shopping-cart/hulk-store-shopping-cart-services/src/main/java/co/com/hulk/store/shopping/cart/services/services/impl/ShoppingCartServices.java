package co.com.hulk.store.shopping.cart.services.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.hulk.store.customer.commons.dto.CustomerDTO;
import co.com.hulk.store.customer.commons.exception.CustomerException;
import co.com.hulk.store.shopping.cart.dto.ItemDTO;
import co.com.hulk.store.shopping.cart.dto.ShoppingCartDTO;
import co.com.hulk.store.shopping.cart.services.model.Item;
import co.com.hulk.store.shopping.cart.services.model.ShoppingCart;
import co.com.hulk.store.shopping.cart.services.repository.ShoppingCartRepository;
import co.com.hulk.store.shopping.cart.services.services.ICustomerServices;
import co.com.hulk.store.shopping.cart.services.services.IShoppingCartServices;

@Service
public class ShoppingCartServices implements IShoppingCartServices {

	@Autowired
	private ShoppingCartRepository repository;

	@Autowired
	private ICustomerServices iCustomerServices;

	@Autowired
	private ModelMapper mapper;

	@Override
	public void delete(String id) {

		// Buscar la entidad
		ShoppingCart shoppingCart = repository.findById(id).orElse(null);

		if (shoppingCart == null) {
			return;
		}

		repository.delete(shoppingCart);

	}

	@Override
	public ShoppingCartDTO findByCustomer(String customerId) {
		return mapper.map(repository.findByCustomerId(customerId), ShoppingCartDTO.class);
	}

	@Override
	public ShoppingCartDTO update(String id, List<ItemDTO> items) {

		// Buscar el carrito de compras del cliente
		ShoppingCart customerShoppingCart = repository.findByCustomerId(id);

		if (customerShoppingCart == null) {
			return null;
		}

		// Modificar los items del carrito de compras
		List<Item> shoppingCartItems = new ArrayList<>();
		for (ItemDTO item2 : items) {
			shoppingCartItems.add(mapper.map(item2, Item.class));
		}
		
		customerShoppingCart.setItems(shoppingCartItems);

		// Actualizar en base de datos
		customerShoppingCart = repository.save(customerShoppingCart);
		return mapper.map(customerShoppingCart, ShoppingCartDTO.class);

	}

	@Override
	public ShoppingCartDTO create(String customerId, List<ItemDTO> items) {

		ShoppingCart customerShoppingCart = new ShoppingCart();

		try {

			// Buscar el cliente
			CustomerDTO customer = iCustomerServices.findById(customerId);
			customerShoppingCart.setCustomer(customer);

			// Modificar los items del carrito de compras
			List<Item> shoppingCartItems = new ArrayList<>();
			for (ItemDTO item2 : items) {
				shoppingCartItems.add(mapper.map(item2, Item.class));
			}
			customerShoppingCart.setItems(shoppingCartItems);

			// Actualizar en base de datos
			customerShoppingCart = repository.save(customerShoppingCart);
			return mapper.map(customerShoppingCart, ShoppingCartDTO.class);

		} catch (CustomerException e) {
			return null;
		}

	}

}
