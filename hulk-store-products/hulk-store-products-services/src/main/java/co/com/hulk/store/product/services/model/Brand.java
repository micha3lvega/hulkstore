package co.com.hulk.store.product.services.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Brand implements Serializable {

	private static final long serialVersionUID = 3581885421391224896L;

	@Id
	private String id;

	private String name;

	private Date createDate;

	private Date lastUpdate;

}
