package co.com.hulk.store.products.commons.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "id", "name", "createDate", "lastUpdate" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ObjectGenericDTO implements Serializable {

	private static final long serialVersionUID = 6684055920314033898L;

	private String id;

	@Size(min = 3, max = 50, message = "El nombre tiene que tener entre 3 y 50 caracteres")
	@NotBlank(message = "El nombre es obligatorio")
	private String name;

	private Date createDate;

	private Date lastUpdate;

}
