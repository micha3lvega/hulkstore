package co.com.hulk.store.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import co.com.hulk.store.product.services.model.Product;
import co.com.hulk.store.product.services.services.impl.SequenceGeneratorService;

@Component
public class ProductModelListener extends AbstractMongoEventListener<Product> {

	private SequenceGeneratorService sequenceGenerator;

	@Autowired
	public ProductModelListener(SequenceGeneratorService sequenceGenerator) {
		this.sequenceGenerator = sequenceGenerator;
	}

	@Override
	public void onBeforeConvert(BeforeConvertEvent<Product> event) {
		
		if (event.getSource().getCode() == null) {
			event.getSource().setCode(this.sequenceGenerator.generateSequence(Product.SEQUENCE_NAME));
		}
		
	}

	
	
}
