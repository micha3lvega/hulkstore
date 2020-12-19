package co.com.hulk.store.product.services.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

	private static final long serialVersionUID = 2824633573725647124L;

	private String id;

	private String name;

	private Date createDate;

	private Date lastUpdate;

}
