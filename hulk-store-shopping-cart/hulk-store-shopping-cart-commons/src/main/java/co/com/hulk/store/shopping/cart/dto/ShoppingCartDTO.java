package co.com.hulk.store.shopping.cart.dto;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

import co.com.hulk.store.customer.commons.dto.CustomerDTO;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartDTO implements Serializable {

	private static final long serialVersionUID = -3322899928591116927L;

	private String id;
	private Long order;
	
	private List<ItemDTO> items;
	private CustomerDTO customer;
	
	private Date createDate;
	private Date lastUpdate;

}
