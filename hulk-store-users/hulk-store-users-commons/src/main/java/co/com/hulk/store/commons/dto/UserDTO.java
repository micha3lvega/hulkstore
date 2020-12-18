package co.com.hulk.store.commons.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "lastName", "email", "mobile", "password", "createDate", "createDate" })
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 4465809113751598045L;

	private String id;

	private String name;
	private String lastName;

	private String email;
	private String mobile;
	private String password;

	private Date createDate;
	private Date lastUpdate;

}
