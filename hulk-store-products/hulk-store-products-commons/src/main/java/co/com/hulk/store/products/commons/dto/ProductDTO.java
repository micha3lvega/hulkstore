package co.com.hulk.store.products.commons.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonPropertyOrder({ "id", "name", "code", "unitPrice", "minStock", "actualStock", "entryDate", "brand", "category",
		"unitOfMeasurement" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO extends ObjectGenericDTO {

	private static final long serialVersionUID = 909506602456072666L;

	private Long code;

	@NotNull(message = "El precio unitario del producto es obligatorio")
	@DecimalMin(value = "0.0", inclusive = true, message = "El precio unitario debe ser mayor o igual a 0")
	private BigDecimal unitPrice;

	@NotNull(message = "El stock minimo del producto es obligatorio")
	@Min(value = 0, message = "El stock minimo debe ser minimo de 0")
	private Integer minStock;

	@NotNull(message = "El stock actual del producto es obligatorio")
	@Min(value = 0, message = "El stock actual debe ser minimo de 0")
	private Integer actualStock;

	private Date entryDate;

	@Valid
	@NotNull(message = "La marca es obligatoria")
	private BrandDTO brand;

	@Valid
	@NotNull(message = "La categoria es obligatoria")
	private CategoryDTO category;

	@Valid
	@NotNull(message = "La unidad de medida es obligatoria")
	private UnitOfMeasurementDTO unitOfMeasurement;

}
