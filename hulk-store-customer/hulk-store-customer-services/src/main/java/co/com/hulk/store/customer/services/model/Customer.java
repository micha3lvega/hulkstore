package co.com.hulk.store.customer.services.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

import co.com.hulk.store.commons.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer implements Serializable {

	private static final long serialVersionUID = 4126764591979764242L;
	
	@Id
	private String id;	
	private UserDTO user;
	private Address address;

}
