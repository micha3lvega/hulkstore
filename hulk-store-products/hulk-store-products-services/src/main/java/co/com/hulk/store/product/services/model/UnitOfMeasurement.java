package co.com.hulk.store.product.services.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UnitOfMeasurement implements Serializable {

	private static final long serialVersionUID = 3325378187800773910L;

	private String id;

	private String name;

	private Date createDate;

	private Date lastUpdate;

}
