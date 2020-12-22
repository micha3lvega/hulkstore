package co.com.hulk.store.shopping.cart.services.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import co.com.hulk.store.products.commons.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable{

	private static final long serialVersionUID = -4936756348420835708L;
	
	@Id
	private String id;
	
	private ProductDTO products;
	private int quantity;

}
