package co.com.hulk.store.commons.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "lastName", "email", "mobile", "password", "createDate", "lastUpdate" })
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 4465809113751598045L;

	private String id;

	@NotBlank(message = "El nombre es obligatorio")
	@Size(min = 3, max = 20, message = "El nombre tiene que tener entre 3 y 20 caracteres")
	private String name;

	@NotBlank(message = "El apellido es obligatorio")
	@Size(min = 3, max = 20, message = "El apellido tiene que tener entre 3 y 20 caracteres")
	private String lastName;

	@Email
	@NotBlank(message = "El correo es obligatorio")
	@Size(min = 3, max = 120, message = "El correo tiene que tener entre 3 y 120 caracteres")
	private String email;

	@NotBlank(message = "El telefono es obligatorio")
	@Size(min = 3, max = 10, message = "El telefono tiene que tener entre 3 y 10 digitos")
	private String mobile;

	@NotEmpty(message = "La contraseña es obligatoria")
	@Size(min = 6, max = 100, message = "La contraseña tiene que tener entre 6 y 100 digitos")
	private String password;

	private Date createDate;

	private Date lastUpdate;

	private List<RolDTO> roles;

	private UserStateDTO state;

}
