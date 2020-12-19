package co.com.hulk.store.services.model;

import java.util.Date;
import java.io.Serializable;

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

	private String name;

	private String lastName;

	private String email;

	private String mobile;

	private String password;

	@CreatedDate
	private Date createDate;

	@LastModifiedDate
	private Date lastUpdate;

	private UserState state;

}
