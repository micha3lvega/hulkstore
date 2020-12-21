package co.com.hulk.store.customer.commons.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import co.com.hulk.store.commons.dto.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO implements Serializable{
	
	private static final long serialVersionUID = 869214375032271103L;

	private String id;	
	private UserDTO user;
	private AddressDTO address;

}
