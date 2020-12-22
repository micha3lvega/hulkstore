package co.com.hulk.store.shopping.cart.services.model;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import co.com.hulk.store.customer.commons.dto.CustomerDTO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart implements Serializable {

	private static final long serialVersionUID = 862611246143397130L;

	@Id
	private String id;
	private Long order;

	private List<Item> items;
	private CustomerDTO customer;

	private Date createDate;
	private Date lastUpdate;

}
