package co.com.hulk.store.customer.commons.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "city", "state", "street"})
public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 8340819102948833298L;

	private String id;

	@NotBlank(message = "La ciudad es obligatoria")
	@Size(min = 3, max = 100, message = "La ciudad tiene que tener entre 3 y 100 caracteres")
	private String city;
	
	@NotBlank(message = "El depertamento es obligatorio")
	@Size(min = 3, max = 100, message = "El depertamento tiene que tener entre 3 y 100 caracteres")
	private String state;
	
	@NotBlank(message = "La direccion es obligatoria")
	@Size(min = 3, message = "La direccion tiene que tener minimo 3 caracteres")
	private String street;

}
