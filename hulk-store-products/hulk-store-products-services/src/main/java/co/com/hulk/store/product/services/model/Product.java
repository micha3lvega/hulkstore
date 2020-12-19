package co.com.hulk.store.product.services.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = -3085204177844220125L;

	private String id;

	private String name;

	private Integer code;

	private Brand brand;

	private Date entryDate;

	private Integer minStock;

	@CreatedDate
	private Date createDate;

	@LastModifiedDate
	private Date lastUpdate;

	private Category category;

	private Integer actualStock;

	private BigDecimal unitPrice;

	private UnitOfMeasurement unitOfMeasurement;

}
