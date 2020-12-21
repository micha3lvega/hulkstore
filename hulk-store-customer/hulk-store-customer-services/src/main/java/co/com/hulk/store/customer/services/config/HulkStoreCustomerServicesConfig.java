package co.com.hulk.store.customer.services.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HulkStoreCustomerServicesConfig {

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
	
}
