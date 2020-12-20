package co.com.hulk.store.products.commons.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@Size(min = 100000, max = 999999, message = "El codigo debe tener 6 caracteres")
	@NotBlank(message = "El codigo es obligatorio")
	private Integer code;

	@DecimalMin(value = "0.0", inclusive = true, message = "El precio unitario debe ser mayor o igual a 0")
	private BigDecimal unitPrice;

	@Min(value = 0, message = "El stock minimo debe ser minimo de 0")
	private Integer minStock;

	@Min(value = 0, message = "El stock actual debe ser minimo de 0")
	private Integer actualStock;

	@NotNull
	private Date entryDate;

	private BrandDTO brand;

	private CategoryDTO category;

	private UnitOfMeasurementDTO unitOfMeasurement;

}
