package co.com.hulk.store.customer.services.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "city", "state", "street"})
public class Address implements Serializable {

	private static final long serialVersionUID = -4263783490612756834L;

	@Id
	private String id;
	private String city;
	private String state;
	private String street;

}
