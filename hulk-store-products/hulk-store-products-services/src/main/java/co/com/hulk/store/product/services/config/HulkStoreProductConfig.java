package co.com.hulk.store.product.services.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HulkStoreProductConfig {

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

}
