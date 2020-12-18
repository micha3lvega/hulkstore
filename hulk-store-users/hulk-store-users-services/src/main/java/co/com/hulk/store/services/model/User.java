package co.com.hulk.store.services.model;

import java.util.Date;
import java.io.Serializable;

import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = -4992187661746595449L;

	@Id
	private String id;

	@NotEmpty(message = "El nombre es obligatorio")
	@Size(min = 3, max = 20, message = "El nombre tiene que tener entre 3 y 20 caracteres")
	private String name;

	@NotEmpty(message = "El apellido es obligatorio")
	@Size(min = 3, max = 20, message = "El apellido tiene que tener entre 3 y 20 caracteres")
	private String lastName;

	@Email
	@NotEmpty(message = "El correo es obligatorio")
	@Pattern(regexp = "[A-Z0-9]+", message="El correo es invalido")
	@Size(min = 3, max = 20, message = "El correo tiene que tener entre 3 y 20 caracteres")
	private String email;

	@NotEmpty(message = "El telefono es obligatorio")
	@Size(min = 3, max = 10, message = "El telefono tiene que tener entre 3 y 10 digitos")
	private String mobile;
	
	@NotEmpty(message = "La contraseña es obligatoria")
	@Size(min = 3, max = 10, message = "El contraseña tiene que tener entre 6 y 50 digitos")
	private String password;

	@CreatedDate
	private Date createDate;
	
	@LastModifiedDate
	private Date lastUpdate;

}
