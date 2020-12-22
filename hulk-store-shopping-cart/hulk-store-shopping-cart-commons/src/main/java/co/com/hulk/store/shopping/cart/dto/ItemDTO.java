package co.com.hulk.store.shopping.cart.dto;

import java.io.Serializable;

import co.com.hulk.store.products.commons.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO implements Serializable {

	private static final long serialVersionUID = -4966684295507435862L;

	private String id;

	private ProductDTO product;
	private int quantity;

}
